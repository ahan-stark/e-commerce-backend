package com.example.ecommerce.service;

import com.example.ecommerce.entities.Products;
import com.example.ecommerce.repository.cart.CartQueryImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CartServices {
    @Autowired
    CartQueryImplementation cartQueryImplementation;

    public void addToCart(Integer userId, Integer productId) {
        cartQueryImplementation.addToCart(userId, productId);
    }

    public List<Products> getCartItems(Integer userId) {
        return cartQueryImplementation.getCartItems(userId);
    }
    public List<Products> deleteCartItem(Integer userId, Integer productId){
        cartQueryImplementation.deleteCartItem(userId,productId);
        return cartQueryImplementation.getCartItems(userId);
    }
}
