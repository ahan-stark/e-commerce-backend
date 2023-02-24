package com.example.ecommerce.service;

import com.example.ecommerce.dto.UserInformation;
import com.example.ecommerce.repository.userInformation.UserInformationQueryImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInformationService {
    @Autowired
    UserInformationQueryImplementation userInformationQueryImplementation;
    public UserInformation getUserDetails(Integer userId){
        return userInformationQueryImplementation.getUserDetails(userId);
    }
}
