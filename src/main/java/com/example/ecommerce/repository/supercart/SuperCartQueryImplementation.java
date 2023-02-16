package com.example.ecommerce.repository.supercart;

import com.example.ecommerce.dto.SuperCartReturn;
import com.example.ecommerce.entities.Cart;
import com.example.ecommerce.entities.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SuperCartQueryImplementation implements SuperCartQuery{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addToSuperCart(Integer userId, Integer productId, Integer productBookingPrice) {
        String query = "insert into ecommerce.super_cart(user_id,product_id,product_booking_price) values (?,?,?)";
        jdbcTemplate.update(query,userId,productId,productBookingPrice);
    }

    @Override
    public List<SuperCartReturn> getSuperCart(Integer userId) {
        return jdbcTemplate.query("select products.product_id,products.product_image,products.product_name,products.product_price,super_cart.product_booking_price from super_cart join products on products.product_id = super_cart.product_id where user_id=" + userId, ((rs, rowNum) -> {
            SuperCartReturn superCartReturn = new SuperCartReturn();
            superCartReturn.setProductId(rs.getInt("product_id"));
            superCartReturn.setProductImage(rs.getString("product_image"));
            superCartReturn.setProductName(rs.getString("product_name"));
            superCartReturn.setProductPrice(rs.getInt("product_price"));
            superCartReturn.setProductBookedPrice(rs.getInt("product_booking_price"));
            return superCartReturn;
        }));
    }
}

