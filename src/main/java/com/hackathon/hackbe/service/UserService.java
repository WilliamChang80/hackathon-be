package com.hackathon.hackbe.service;

import com.hackathon.hackbe.dto.request.AuthRequest;
import com.hackathon.hackbe.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    void createUser(AuthRequest authRequest);

    User getUserByEmail(String email);

    User getUserById(Long userId);

    boolean isValidLoginCredentials(String email, String password);

}
