package com.example.ecommerce.repository.orders;

import com.example.ecommerce.entities.Cart;
import com.example.ecommerce.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
