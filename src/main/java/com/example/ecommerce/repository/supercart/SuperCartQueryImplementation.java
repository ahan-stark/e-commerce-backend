package com.example.ecommerce.repository.supercart;

import com.example.ecommerce.dto.NotifyReturn;
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
public class SuperCartQueryImplementation implements SuperCartQuery {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addToSuperCart(Integer userId, Integer productId, Integer productBookingPrice) {
        String query = "insert into ecommerce.super_cart(user_id,product_id,product_booking_price) values (?,?,?)";
        jdbcTemplate.update(query, userId, productId, productBookingPrice);
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

    @Override
    public void deleteSuperCart(Integer userId, Integer productId) {
        String query = "delete from super_cart where product_id=? and user_id=?";
        jdbcTemplate.update(query, productId, userId);
    }

    @Override
    public SuperCartReturn checkSuperCart(Integer userId, Integer productId) {
        String sql = "select products.product_id,products.product_image,products.product_name,products.product_price,super_cart.product_booking_price from super_cart join products on products.product_id = super_cart.product_id where super_cart.user_id=? and super_cart.product_id=?";
        try {
            SuperCartReturn superCartReturn = jdbcTemplate.queryForObject(sql, new Object[]{userId, productId}, new RowMapper<SuperCartReturn>() {
                @Override
                public SuperCartReturn mapRow(ResultSet rs, int rowNum) throws SQLException {
                    SuperCartReturn superCartReturn =new SuperCartReturn();
                    superCartReturn.setProductId(rs.getInt("product_id"));
                    superCartReturn.setProductPrice(rs.getInt("product_price"));
                    superCartReturn.setProductBookedPrice(rs.getInt("product_booking_price"));
                    superCartReturn.setProductImage(rs.getString("product_image"));
                    superCartReturn.setProductName(rs.getString("product_name"));
                    return superCartReturn;
                }
            });
            return superCartReturn;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<NotifyReturn> getItemsToNotify() {
        try{
        String query ="select products.product_id, products.product_price,products.product_name,super_cart.product_booking_price,super_cart.user_id,super_cart.booking_status from products join super_cart on products.product_id = super_cart.product_id";
        return  jdbcTemplate.query(query, ((rs, rowNum) -> {
            NotifyReturn notifyReturn = new NotifyReturn();
            notifyReturn.setProductId(rs.getInt("product_id"));
            notifyReturn.setProductPrice(rs.getInt("product_price"));
            notifyReturn.setProductName(rs.getString("product_name"));
            notifyReturn.setProductBookingPrice(rs.getInt("product_booking_price"));
            notifyReturn.setUserId(rs.getInt("user_id"));
            notifyReturn.setBookingStatus(rs.getString("booking_status"));
            return notifyReturn;
        }));
    }
        catch (Exception e){
            return  null;
        }
    }

    @Override
    public void updateSuperCartStatus(Integer userId, Integer productId) {
      String sql =  "UPDATE super_cart SET booking_status = 'notified' WHERE  user_id = ? && product_id = ?";
      jdbcTemplate.update(sql,userId,productId);
    }
}

