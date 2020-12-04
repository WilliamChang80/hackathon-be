package com.hackathon.hackbe.dto.response;

import com.hackathon.hackbe.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class AuthResponse {
    private String token;
    private UserResponse user;
}