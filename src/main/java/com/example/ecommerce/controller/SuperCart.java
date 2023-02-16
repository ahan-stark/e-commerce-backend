package com.example.ecommerce.controller;

import com.example.ecommerce.dto.SuperCartReturn;
import com.example.ecommerce.service.SuperCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class SuperCart {
    @Autowired
    SuperCartService superCartService;
    @PostMapping("/super-cart/{userId}/{productId}/{productBookingPrice}")
    public void addToSuperCart(@PathVariable("userId")Integer userId, @PathVariable("productId") Integer productId, @PathVariable("productBookingPrice") Integer productBookingPrice){
        superCartService.addToSuperCart(userId,productId,productBookingPrice);
    }
    @GetMapping("/super-cart/{userId}")
    public List<SuperCartReturn> getSuperCart(@PathVariable("userId")Integer userId){
        return superCartService.getSuperCart(userId);
    }
}
