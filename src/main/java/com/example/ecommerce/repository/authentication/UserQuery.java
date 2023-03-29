package com.example.ecommerce.repository.authentication;

import com.example.ecommerce.dto.UserRegisterValidation;

public interface UserQuery {
    public UserRegisterValidation checkSignUpUser(String userName);
}
