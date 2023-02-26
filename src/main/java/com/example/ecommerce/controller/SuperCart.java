package com.example.ecommerce.controller;

import com.example.ecommerce.dto.NotifyReturn;
import com.example.ecommerce.dto.SuperCartReturn;
import com.example.ecommerce.dto.UserInformation;
import com.example.ecommerce.service.SuperCartService;
import com.example.ecommerce.service.TwilioService;
import com.example.ecommerce.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SuperCart {
    @Autowired
    SuperCartService superCartService;
    @Autowired
    UserInformationService userInformationService;
    @Autowired
    TwilioService twilioService;

    @PostMapping("/super-cart/{userId}/{productId}/{productBookingPrice}")
    public void addToSuperCart(@PathVariable("userId") Integer userId, @PathVariable("productId") Integer productId, @PathVariable("productBookingPrice") Integer productBookingPrice) {
        superCartService.addToSuperCart(userId, productId, productBookingPrice);
    }

    @GetMapping("/super-cart/{userId}")
    public List<SuperCartReturn> getSuperCart(@PathVariable("userId") Integer userId) {
        return superCartService.getSuperCart(userId);
    }

    @DeleteMapping("/super-cart/{userId}/{productId}")
    public void deleteSuperCart(@PathVariable("userId") Integer userId, @PathVariable("productId") Integer productId) {
        superCartService.deleteSuperCart(userId, productId);
    }

    @GetMapping("/check-superCart/{userId}/{productId}")
    public SuperCartReturn checkSuperCart(@PathVariable("userId") Integer userId, @PathVariable("productId") Integer productId) {
        return superCartService.checkSuperCart(userId, productId);
    }

    @GetMapping("notify-user")
    public void getItemsToNotify() {
        List<NotifyReturn> val = superCartService.getItemsToNotify();
        for (NotifyReturn a : val) {
            if (a.getProductBookingPrice() > a.getProductPrice()) {
                UserInformation userInformation = userInformationService.getUserDetails(a.getUserId());
                if (a.getBookingStatus().equals("notify")) {
                    System.out.println("notify");
                    superCartService.updateSuperCartStatus(a.getUserId(), a.getProductId());
                    //                twilioService.sendSms(String.valueOf(userInformation.getUserPhoneNo()),"your desired product"+ a.getProductName()+"is below "+ a.getProductBookingPrice()+" buy it now!"+" Devaiah ");
                } else if (a.getBookingStatus().equals("notified")) {
                    System.out.println("buy it");
                }
            }
        }
    }
}
