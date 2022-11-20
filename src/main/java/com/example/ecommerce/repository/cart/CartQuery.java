package com.example.ecommerce.repository.cart;

public interface CartQuery {
    void addToCart(Integer userId, Integer productId);
}
