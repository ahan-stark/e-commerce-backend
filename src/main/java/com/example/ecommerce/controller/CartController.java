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

    @PostMapping("/cart/{userId}/{productId}")
    public void addToCart(@PathVariable("productId") Integer productId, @PathVariable("userId") Integer userId) {
        cartServices.addToCart(userId, productId);
    }

    @GetMapping("/cart/{userId}")
    public List<Products> getCartItems(@PathVariable("userId") Integer userId) {
        return cartServices.getCartItems(userId);
    }

    @DeleteMapping("/cart/{userId}/{productId}")
    public List<Products> deleteCartItem(@PathVariable("userId") Integer userId, @PathVariable("productId") Integer productId) {
        cartServices.deleteCartItem(userId, productId);
        return cartServices.getCartItems(userId);
    }
    @GetMapping("/check-cart/{userId}/{productId}")
    public Cart checkIfProductExists(@PathVariable("userId")Integer userId,@PathVariable("productId")Integer productId){
            return cartServices.checkIfProductExists(userId, productId);

        }
    }

