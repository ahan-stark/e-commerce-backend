package com.example.ecommerce.service;

import com.example.ecommerce.repository.cart.CartQueryImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CartServices {
    @Autowired
    CartQueryImplementation cartQueryImplementation;
    public void addToCart(Integer userId, Integer productId){
        cartQueryImplementation.addToCart(userId,productId);
    }
}
