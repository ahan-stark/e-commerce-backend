package com.example.ecommerce.controller;

import com.example.ecommerce.dto.OrderValue;
import com.example.ecommerce.entities.Products;
import com.example.ecommerce.service.OrderServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OrderController {
    OrderServices orderServices;

    public OrderController(OrderServices orderServices) {
        this.orderServices = orderServices;
    }

    @PostMapping("/orders/{userId}")
    public void addToOrders(@PathVariable("userId") Integer userId) {
        orderServices.addToOrders(userId);
    }

    @GetMapping("/orders/{userId}")
    public List<OrderValue> getOrders(@PathVariable("userId") Integer userId) {
        return orderServices.getOrders(userId);
    }

    @DeleteMapping("/orders/{userId}/{productId}")
    public void deleteOrders(@PathVariable("userId") Integer userId, @PathVariable("productId") Integer productId) {
        orderServices.deleteOrderedProduct(userId, productId);
    }
}
