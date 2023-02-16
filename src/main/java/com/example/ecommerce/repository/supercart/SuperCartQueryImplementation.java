package com.example.ecommerce.repository.supercart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SuperCartQueryImplementation implements SuperCartQuery{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addToSuperCart(Integer userId, Integer productId, Integer productBookingPrice) {
        String query = "insert into ecommerce.super_cart(user_id,product_id,product_booking_price) values (?,?,?)";
        jdbcTemplate.update(query,userId,productId,productBookingPrice);
    }
}
