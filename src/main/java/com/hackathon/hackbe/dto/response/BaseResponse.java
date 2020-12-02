package com.hackathon.hackbe.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class BaseResponse {
    private int code;
    private String message;
    private Object data;
}
