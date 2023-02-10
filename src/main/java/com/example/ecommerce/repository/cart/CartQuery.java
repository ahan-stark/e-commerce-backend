package com.example.ecommerce.repository.cart;

import com.example.ecommerce.entities.Cart;
import com.example.ecommerce.entities.Products;

import java.util.List;

public interface CartQuery {
    void addToCart(Integer userId, Integer productId);

    List<Products> getCartItems(Integer userId);

    void deleteCartItem(Integer userId, Integer productId);
    Cart checkIfProductExists(Integer userId, Integer productId);
}
