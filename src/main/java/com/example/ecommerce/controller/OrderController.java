package com.example.ecommerce.controller;

import com.example.ecommerce.service.OrderServices;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
