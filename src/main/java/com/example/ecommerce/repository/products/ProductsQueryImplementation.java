package com.example.ecommerce.repository.products;

import com.example.ecommerce.entities.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductsQueryImplementation implements ProductQuery {
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
            products.setProductPrice(rs.getInt("product_price"));
            return products;
        });
    }

    @Override
    public Products getIndividualProduct(int productId) {
//        return jdbcTemplate.query("select * from products where product_id = "+productId, (rs, rowNum) -> {
//
//            Products products = new Products();
//            products.setProductId(rs.getInt("product_id"));
//            products.setProductCategoryId(rs.getInt("product_category_id"));
//            products.setProductName(rs.getString("product_name"));
//            products.setProductImage(rs.getString("product_image"));
//            return
//                    0;
//        });
        String sql = "select product_id,product_name,product_price,product_image,product_category_id from products where product_id = ?";
       return jdbcTemplate.queryForObject(sql, new Object[]{productId}, new RowMapper<Products>() {
            @Override
            public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
               Products products =new Products();
               products.setProductId((Integer) rs.getObject("product_id"));
               products.setProductName((String) rs.getObject("product_name"));
               products.setProductImage((String) rs.getObject("product_image"));
               products.setProductCategoryId((Integer) rs.getObject("product_category_id"));
               products.setProductPrice((Integer)rs.getObject("product_price") );
               return products;
            }
        });

    }

    @Override
    public List<Products> getMobileProducts() {
        return jdbcTemplate.query("select * from products where product_category_id = 1 limit 4 ", (rs, rowNum) -> {

            Products products = new Products();
            products.setProductId(rs.getInt("product_id"));
            products.setProductCategoryId(rs.getInt("product_category_id"));
            products.setProductName(rs.getString("product_name"));
            products.setProductImage(rs.getString("product_image"));
            products.setProductPrice(rs.getInt("product_price"));
            return products;
        });
    }

    @Override
    public List<Products> getTrendyProducts() {
        return jdbcTemplate.query("SELECT * from products order by rand() limit 10;", (rs, rowNum) -> {

            Products products = new Products();
            products.setProductId(rs.getInt("product_id"));
            products.setProductCategoryId(rs.getInt("product_category_id"));
            products.setProductName(rs.getString("product_name"));
            products.setProductImage(rs.getString("product_image"));
            products.setProductPrice(rs.getInt("product_price"));
            return products;
        });
    }
}
