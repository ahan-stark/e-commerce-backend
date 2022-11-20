package com.example.ecommerce.controller;

import com.example.ecommerce.entities.Cart;
import com.example.ecommerce.service.CartServices;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CartController {
    public CartController(CartServices cartServices) {
        this.cartServices = cartServices;
    }
    CartServices cartServices;
    @PostMapping("/cart/{productId}/{userId}")
    public void addToCart(@PathVariable("productId") Integer productId, @PathVariable("userId") Integer userId){
        cartServices.addToCart(userId,productId);

    }

}
