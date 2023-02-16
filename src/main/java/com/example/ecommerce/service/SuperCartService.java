package com.example.ecommerce.service;

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
}
