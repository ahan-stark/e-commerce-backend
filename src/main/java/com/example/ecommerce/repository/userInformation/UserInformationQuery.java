package com.example.ecommerce.repository.userInformation;

import com.example.ecommerce.dto.UserInformation;

public interface UserInformationQuery {
    public UserInformation getUserDetails(Integer userId);
}
