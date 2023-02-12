package com.example.ecommerce.repository.orders;

import com.example.ecommerce.dto.OrderValue;
import com.example.ecommerce.entities.Cart;
import com.example.ecommerce.entities.Products;

import java.util.List;

public interface OrdersQuery {
    public List<Cart> getCartItems(Integer userId);

    public void addToOrders(List<Cart> cart, Integer userId);

    public void deleteCartItems(Integer userId);

    public List<OrderValue> getOrders(Integer userId);

    public void deleteOrderedProduct(Integer userId, Integer productId);
}
