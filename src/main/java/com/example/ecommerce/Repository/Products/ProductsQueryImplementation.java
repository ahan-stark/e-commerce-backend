package com.example.ecommerce.Repository.Products;

import com.example.ecommerce.Entities.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductsQueryImplementation implements ProductQuery{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Products> getProductByCategoryId(int id) {
        return jdbcTemplate.query("select * from products where product_category_id = " + id, (rs, rowNum) -> {

            Products products = new Products();
            products.setProductId(rs.getInt("product_id"));
            products.setProductCategoryId(rs.getInt("product_category_id"));
            products.setProductName(rs.getString("product_name"));
            products.setProductImage(rs.getString("product_image"));
            return products;
        });
    }
}
