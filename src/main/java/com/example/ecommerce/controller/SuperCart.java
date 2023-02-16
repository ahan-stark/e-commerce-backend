package com.example.ecommerce.controller;

import com.example.ecommerce.service.SuperCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SuperCart {
    @Autowired
    SuperCartService superCartService;
    @PostMapping("/super-cart/{userId}/{productId}/{productBookingPrice}")
    public void addToSuperCart(@PathVariable("userId")Integer userId, @PathVariable("productId") Integer productId, @PathVariable("productBookingPrice") Integer productBookingPrice){
        superCartService.addToSuperCart(userId,productId,productBookingPrice);
    }
}
