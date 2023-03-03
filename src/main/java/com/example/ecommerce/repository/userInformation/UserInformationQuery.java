package com.example.ecommerce.repository.userInformation;

import com.example.ecommerce.dto.UserInformation;
import com.example.ecommerce.entities.User;

public interface UserInformationQuery {
    public User getUserDetails(Long userId);
    public Long getUserId(String username);
}
