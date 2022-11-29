package com.example.ecommerce.repository.orders;

import com.example.ecommerce.entities.Cart;

import java.util.List;

public interface OrdersQuery {
    public List<Cart> getCartItems(Integer userId);
    public  void addToOrders(List<Cart> cart,Integer userId);
    public  void deleteCartItems(Integer userId);
}
