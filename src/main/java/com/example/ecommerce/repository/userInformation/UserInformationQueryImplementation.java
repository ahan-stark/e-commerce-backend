package com.example.ecommerce.repository.userInformation;

import com.example.ecommerce.dto.UserInformation;
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
    public UserInformation getUserDetails(Integer userId) {
        String query = "select user_id, user_name, user_address, user_phone_no from user_details where user_id = ?";
        UserInformation userInformation = jdbcTemplate.queryForObject(query, new Object[]{userId}, new RowMapper<UserInformation>() {
            @Override
            public UserInformation mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserInformation userInformation = new UserInformation();
                userInformation.setUserId(rs.getInt("user_id"));
                userInformation.setUserName(rs.getString("user_name"));
                userInformation.setUserPhoneNo(rs.getLong("user_phone_no"));
                userInformation.setUserAddress(rs.getString("user_address"));
                return userInformation;
            }
        });
        return userInformation;
    }
}
