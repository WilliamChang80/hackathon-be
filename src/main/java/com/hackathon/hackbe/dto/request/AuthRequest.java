package com.hackathon.hackbe.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class AuthRequest {
    private String email;
    private String password;
}
