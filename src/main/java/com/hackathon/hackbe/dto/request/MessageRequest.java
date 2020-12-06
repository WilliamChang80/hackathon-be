package com.hackathon.hackbe.dto.request;

import com.hackathon.hackbe.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequest {
    User sender;
    String message;
}
