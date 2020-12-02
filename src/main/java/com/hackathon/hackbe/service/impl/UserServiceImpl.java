package com.hackathon.hackbe.service.impl;

import com.hackathon.hackbe.dto.request.AuthRequest;
import com.hackathon.hackbe.dto.response.UserResponse;
import com.hackathon.hackbe.entity.User;
import com.hackathon.hackbe.repository.UserRepository;
import com.hackathon.hackbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void createUser(AuthRequest authRequest) {
        String hashedPassword = BCrypt.hashpw(authRequest.getPassword(), BCrypt.gensalt(10));
        User user = User.builder().email(authRequest.getEmail()).password(hashedPassword).build();
        userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getByEmailEquals(email);

    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public boolean isValidLoginCredentials(String email, String password) {
        User user = userRepository.getByEmailEquals(email);
        if (user == null) {
            return false;
        }
        return BCrypt.checkpw(password, user.getPassword());
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getByEmailEquals(email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                new ArrayList<>());
    }

    private UserResponse convertUserToResponse(User user) {
        return UserResponse.builder().id(user.getId()).email(user.getEmail()).build();
    }
}
