package com.example.ecommerce.repository.orders;

import com.example.ecommerce.entities.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class OrdersQueryImplementation implements OrdersQuery{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Cart> getCartItems(Integer userId) {
        List<Cart> cartItemsOfTheUser;
        cartItemsOfTheUser = jdbcTemplate.query("select user_id,product_id from cart where user_id ="+userId,((rs, rowNum) ->{
            Cart cart = new Cart();
            cart.setUserId(rs.getInt("user_id"));
            cart.setProductId(rs.getInt("product_id"));
            return cart;
        }));
        return cartItemsOfTheUser;
    }

    @Override
    public void addToOrders(List<Cart> cart, Integer userId) {
        Long millis = System.currentTimeMillis();
        for (Cart individualItems: cart) {
            String insertToOrders = "insert into orders(user_id,product_id,order_time_stamp) values (?,?,?)";
            jdbcTemplate.update(insertToOrders,individualItems.getUserId(),individualItems.getProductId(),millis);
        }

    }

    @Override
    public void deleteCartItems(Integer userId) {
        String deleteFromCart = "delete from cart where user_id = ?";
        jdbcTemplate.update(deleteFromCart,userId);
    }
}
