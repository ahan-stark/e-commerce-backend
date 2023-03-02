package com.example.ecommerce.repository.orders;

import com.example.ecommerce.dto.OrderValue;
import com.example.ecommerce.entities.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdersQueryImplementation implements OrdersQuery {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Cart> getCartItems(Integer userId) {
        List<Cart> cartItemsOfTheUser;
        cartItemsOfTheUser = jdbcTemplate.query("select cart_id,user_id,product_id from cart where user_id =" + userId, ((rs, rowNum) -> {
            Cart cart = new Cart();
            cart.setCartId(rs.getInt("cart_id"));
            cart.setUserId(rs.getLong("user_id"));
            cart.setProductId(rs.getInt("product_id"));
            return cart;
        }));
        return cartItemsOfTheUser;
    }

    @Override
    public void addToOrders(List<Cart> cart, Integer userId) {
        Long millis = System.currentTimeMillis();
        for (Cart individualItems : cart) {
            String insertToOrders = "insert into orders(user_id,product_id,order_time_stamp) values (?,?,?)";
            jdbcTemplate.update(insertToOrders, individualItems.getUserId(), individualItems.getProductId(), millis);
        }

    }

    @Override
    public void deleteCartItems(Integer userId) {
        String deleteFromCart = "delete from cart where user_id = ?";
        jdbcTemplate.update(deleteFromCart, userId);
    }

    @Override
    public List<OrderValue> getOrders(Integer userId) {
        List<OrderValue> orderValues;
        orderValues = jdbcTemplate.query("select products.product_id,products.product_image,products.product_name,products.product_price,orders.order_time_stamp FROM products inner join orders on orders.product_id = products.product_id where user_id=" + userId, ((rs, rowNum) -> {
            OrderValue orderValue = new OrderValue();
            orderValue.setProductId(rs.getInt("product_id"));
            orderValue.setProductName(rs.getString("product_name"));
            orderValue.setProductImage(rs.getString("product_image"));
            orderValue.setProductPrice(rs.getInt("product_price"));
            orderValue.setOrderTime(rs.getLong("order_time_stamp"));
            return orderValue;
        }));
        return orderValues;
    }

    @Override
    public void deleteOrderedProduct(Integer userId, Integer productId) {
        String deleteProduct = "delete from orders where user_id = ? and product_id = ?";
        jdbcTemplate.update(deleteProduct, userId, productId);
    }
}
