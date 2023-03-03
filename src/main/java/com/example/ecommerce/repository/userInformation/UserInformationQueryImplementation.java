package com.example.ecommerce.repository.userInformation;

import com.example.ecommerce.dto.UserInformation;
import com.example.ecommerce.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
@Repository
public class UserInformationQueryImplementation implements UserInformationQuery {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getUserDetails(Long userId) {
        String query = "select user_id, username, user_phone_no From user where user_id = ?";
        User user = jdbcTemplate.queryForObject(query, new Object[]{userId}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUserId(rs.getLong("user_id"));
                user.setUsername(rs.getString("username"));
                user.setUserPhoneNo(rs.getLong("user_phone_no"));
                return user;
            }
        });
        return user;
    }

    @Override
    public Long getUserId(String username) {
        String sql = "SELECT user_id FROM user WHERE username = ?";
        Long userId = jdbcTemplate.queryForObject(sql, Long.class, username);
        return userId;
    }
}
