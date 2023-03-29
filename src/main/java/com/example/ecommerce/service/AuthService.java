package com.example.ecommerce.service;

import com.example.ecommerce.dto.AuthenticationResponse;
import com.example.ecommerce.dto.LoginRequest;
import com.example.ecommerce.dto.RegisterRequest;
import com.example.ecommerce.dto.UserRegisterValidation;
import com.example.ecommerce.entities.User;
import com.example.ecommerce.repository.authentication.UserQueryImplementation;
import com.example.ecommerce.repository.authentication.UserRepository;
import com.example.ecommerce.security.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    @Autowired
    UserInformationService userInformationService;
    @Autowired
    UserQueryImplementation userQueryImplementation;

    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            String token = jwtProvider.generateToken(authenticate);
            Long userId = userInformationService.getUserId(loginRequest.getUsername());

            return AuthenticationResponse.builder()
                    .authenticationToken(token)
                    .username(loginRequest.getUsername())
                    .userId(userId)
                    .build();
    }

    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreated(Instant.now());
        user.setUserPhoneNo(registerRequest.getPhoneNum());

        userRepository.save(user);
    }
    public UserRegisterValidation checkSignUpUser(String userName){
        return userQueryImplementation.checkSignUpUser(userName);
    }

}
