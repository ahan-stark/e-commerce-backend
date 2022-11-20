package com.example.ecommerce.repository.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CartQueryImplementation implements CartQuery {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void addToCart(Integer userId, Integer productId) {
        String insertQuery = "insert into cart (user_id, product_id) values (?, ?)";
        jdbcTemplate.update(insertQuery,userId,productId);

    }
}
