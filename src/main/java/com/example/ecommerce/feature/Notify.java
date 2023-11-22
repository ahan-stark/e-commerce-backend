package com.example.ecommerce.feature;

import com.example.ecommerce.dto.NotifyReturn;
import com.example.ecommerce.entities.User;
import com.example.ecommerce.service.SuperCartService;
import com.example.ecommerce.service.TwilioService;
import com.example.ecommerce.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableScheduling
public class Notify {
    @Autowired
    SuperCartService superCartService;
    @Autowired
    UserInformationService userInformationService;
    @Autowired
    TwilioService twilioService;
    @Scheduled(fixedRate = 60000)
    public void getItemsToNotify() {
        List<NotifyReturn> val = superCartService.getItemsToNotify();
        for (NotifyReturn a : val) {
            if (a.getProductBookingPrice() > a.getProductPrice()) {
                User user = userInformationService.getUserDetails(a.getUserId());
                if (a.getBookingStatus().equals("notify")) {
                    System.out.println("notify");
                    superCartService.updateSuperCartStatus(a.getUserId(), a.getProductId());
                    twilioService.sendSms(String.valueOf(user.getUserPhoneNo()),"your desired product "+ a.getProductName()+"is below "+ a.getProductBookingPrice()+" buy it now!");
                } else if (a.getBookingStatus().equals("notified")) {
                    System.out.println("buy it");
                    bookFromSuperCart(a.getUserId(), a.getProductId());
                    deleteFromSuperCartAfterCheckOut(a.getUserId(), a.getProductId());
                }
            }
        }
    }
    public void bookFromSuperCart(Long userId, Integer productId) {
        superCartService.bookFromSuperCart(userId, productId);
    }

    public void deleteFromSuperCartAfterCheckOut(Long userId, Integer productId) {
        superCartService.deleteSuperCart(userId, productId);
    }
}
