package com.hackathon.hackbe.controller;

import com.hackathon.hackbe.dto.response.BaseResponse;
import com.hackathon.hackbe.entity.User;
import com.hackathon.hackbe.enums.Role;
import com.hackathon.hackbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private boolean updatedUsernameValid(String email, Long userId) {
        User user = userService.getUserById(userId);
        if (!email.equals(user.getEmail())) {
            User userTemp = userService.getUserByEmail(email);
            return userTemp == null || userTemp.getId().equals(userId);
        }
        return true;
    }
}
