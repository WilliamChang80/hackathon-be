package com.hackathon.hackbe.controller;

import com.hackathon.hackbe.dto.request.AuthRequest;
import com.hackathon.hackbe.dto.response.AuthResponse;
import com.hackathon.hackbe.dto.response.BaseResponse;
import com.hackathon.hackbe.dto.response.UserResponse;
import com.hackathon.hackbe.entity.User;
import com.hackathon.hackbe.enums.Role;
import com.hackathon.hackbe.service.UserService;
import com.hackathon.hackbe.url.Url;
import com.hackathon.hackbe.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AuthController {

    private AuthenticationManager authManager;
    private JwtUtil jwtUtil;

    private UserService userService;

    @Autowired
    public AuthController(AuthenticationManager authManager, JwtUtil jwtUtil,
                          UserService userService) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @PostMapping(Url.LOGIN_URL)
    public BaseResponse createAuthenticationToken(@RequestBody AuthRequest authenticationRequest)
            throws Exception {
        try {
            if (!userService.isValidLoginCredentials(authenticationRequest.getEmail(),
                    authenticationRequest.getPassword())) {
                throw new BadCredentialsException("Username and password not match !");
            }
        } catch (BadCredentialsException e) {
            return BaseResponse.builder().code(HttpStatus.UNAUTHORIZED.value()).message(e.getMessage()).build();
        }
        UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getEmail());
        User user = userService.getUserByEmail(authenticationRequest.getEmail());
        String jwt = jwtUtil.generateToken(userDetails);
        UserResponse userResponse = UserResponse.builder().id(user.getId()).email(user.getEmail()).build();
        List<Role> roles = userService.getUserRoles(user.getId());
        BaseResponse response = BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").data(
                AuthResponse.builder().token(jwt).user(userResponse).build()).build();
        return response;
    }

    @PostMapping(Url.REGISTER_URL)
    public BaseResponse register(@RequestBody AuthRequest authenticationRequest) {
        if (!emailValid(authenticationRequest.getEmail())) {
            return BaseResponse.builder().code(HttpStatus.UNPROCESSABLE_ENTITY.value())
                    .message(
                            "Email Already Taken!")
                    .build();
        }
        userService.createUser(authenticationRequest);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success")
                .build();
    }

    private boolean emailValid(String email) {
        return userService.getUserByEmail(email) == null;
    }
}