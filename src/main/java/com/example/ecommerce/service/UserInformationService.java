package com.example.ecommerce.service;

import com.example.ecommerce.dto.UserInformation;
import com.example.ecommerce.entities.User;
import com.example.ecommerce.repository.userInformation.UserInformationQueryImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInformationService {
    @Autowired
    UserInformationQueryImplementation userInformationQueryImplementation;
    public User getUserDetails(Long userId){
        return userInformationQueryImplementation.getUserDetails(userId);
    }
    public Long getUserId(String username){
        return  userInformationQueryImplementation.getUserId(username);

    }
}
