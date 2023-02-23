package com.example.ecommerce.service;

import com.example.ecommerce.dto.NotifyReturn;
import com.example.ecommerce.dto.SuperCartReturn;
import com.example.ecommerce.repository.supercart.SuperCartQueryImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperCartService {
    @Autowired
    SuperCartQueryImplementation superCartQueryImplementation;
    public void addToSuperCart(Integer userId, Integer productId, Integer productBookingPrice){
        superCartQueryImplementation.addToSuperCart(userId,productId,productBookingPrice);
    }

    public List<SuperCartReturn> getSuperCart(Integer userId) {
        return superCartQueryImplementation.getSuperCart(userId);
    }

    public void deleteSuperCart(Integer userId, Integer productId) {
        superCartQueryImplementation.deleteSuperCart(userId,productId);
    }

    public SuperCartReturn checkSuperCart(Integer userId, Integer productId) {
        return superCartQueryImplementation.checkSuperCart(userId,productId);
    }

    public List<NotifyReturn> getItemsToNotify() {
        return superCartQueryImplementation.getItemsToNotify();
    }
}
