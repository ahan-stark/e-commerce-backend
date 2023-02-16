package com.example.ecommerce.repository.cart;

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
public class CartQueryImplementation implements CartQuery {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addToCart(Integer userId, Integer productId) {
        String insertQuery = "insert into cart (user_id, product_id) values (?, ?)";
        jdbcTemplate.update(insertQuery,new Object[]{userId,productId});

    }

    @Override
    public List<Products> getCartItems(Integer userId) {
        return jdbcTemplate.query("select products.product_id, products.product_name, products.product_category_id,products.product_image,products.product_price  from products inner join cart on cart.product_id = products.product_id where cart.user_id = " + userId, ((rs, rowNum) -> {
            Products products = new Products();
            products.setProductId(rs.getInt("product_id"));
            products.setProductCategoryId(rs.getInt("product_category_id"));
            products.setProductName(rs.getString("product_name"));
            products.setProductImage(rs.getString("product_image"));
            products.setProductPrice(rs.getInt("product_price"));
            return products;
        }));
    }

    @Override
    public void deleteCartItem(Integer userId, Integer productId) {
        String cartItemDeleteQuery = "delete from cart where user_id = ? and product_id = ?";
        jdbcTemplate.update(cartItemDeleteQuery, userId, productId);
    }

    @Override
    public Cart checkIfProductExists(Integer userId, Integer productId) {
        String sql = "select cart_id, product_id,user_id from cart where user_id = ? and product_id = ?";
        try{
            Cart cart = jdbcTemplate.queryForObject(sql, new Object[]{userId, productId}, new RowMapper<Cart>() {
                @Override
                public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Cart cart = new Cart();
                    cart.setCartId((Integer) rs.getObject("cart_id"));
                    cart.setUserId((Integer) rs.getObject("user_id"));
                    cart.setProductId((Integer) rs.getObject("product_id"));
                    return cart;
                }

            });
            return cart;
        }
        catch (Exception e) {
            return null;
        }
    }
}
