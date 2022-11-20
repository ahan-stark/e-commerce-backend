package com.example.ecommerce.controller;

import com.example.ecommerce.entities.Cart;
import com.example.ecommerce.entities.Products;
import com.example.ecommerce.service.CartServices;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/cart/{userId}")
    public List<Products> getCartItems(@PathVariable("userId") Integer userId){
        return cartServices.getCartItems(userId);
    }


}
