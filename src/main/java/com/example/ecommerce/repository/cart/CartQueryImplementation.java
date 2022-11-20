package com.example.ecommerce.repository.cart;

import com.example.ecommerce.entities.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartQueryImplementation implements CartQuery {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addToCart(Integer userId, Integer productId) {
        String insertQuery = "insert into cart (user_id, product_id) values (?, ?)";
        jdbcTemplate.update(insertQuery, userId, productId);

    }

    @Override
    public List<Products> getCartItems(Integer userId) {
        return jdbcTemplate.query("select products.product_id, products.product_name, products.product_category_id,products.product_image  from products inner join cart on cart.product_id = products.product_id where cart.user_id = " + userId, ((rs, rowNum) -> {
            Products products = new Products();
            products.setProductId(rs.getInt("product_id"));
            products.setProductCategoryId(rs.getInt("product_category_id"));
            products.setProductName(rs.getString("product_name"));
            products.setProductImage(rs.getString("product_image"));
            return products;
        }));
    }
}
