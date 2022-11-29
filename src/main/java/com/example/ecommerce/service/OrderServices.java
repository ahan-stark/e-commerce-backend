package com.example.ecommerce.service;

import com.example.ecommerce.entities.Cart;
import com.example.ecommerce.entities.Products;
import com.example.ecommerce.repository.cart.CartQueryImplementation;
import com.example.ecommerce.repository.orders.OrdersQueryImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServices {
    @Autowired
    OrdersQueryImplementation ordersQueryImplementation;

    public void addToOrders(Integer userId) {
        List<Cart> cartItems = ordersQueryImplementation.getCartItems(userId);
        ordersQueryImplementation.addToOrders(cartItems,userId);
        ordersQueryImplementation.deleteCartItems(userId);

    }
}
