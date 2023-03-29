package com.example.ecommerce.repository.authentication;

import com.example.ecommerce.dto.UserRegisterValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserQueryImplementation implements UserQuery{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    UserRegisterValidation userRegisterValidation = new UserRegisterValidation();
    @Override
    public UserRegisterValidation checkSignUpUser(String userName) {
        String sql = "Select username from user where username = ?;";
        Object[] objects = new Object[]{userName};
        RowMapper<String> rowMapper = (rs,rowNum)->rs.getString("username");
        List<String> res= jdbcTemplate.query(sql,objects,rowMapper);
        if(!res.isEmpty()){
            userRegisterValidation.setUserRegistercheck("success");
            return userRegisterValidation;
        }
        userRegisterValidation.setUserRegistercheck("failed");
        return userRegisterValidation;
    }
}
