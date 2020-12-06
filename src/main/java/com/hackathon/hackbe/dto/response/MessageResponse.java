package com.hackathon.hackbe.dto.response;

import com.hackathon.hackbe.dto.entity.MessageDto;
import com.hackathon.hackbe.dto.entity.UserDto;
import com.hackathon.hackbe.entity.Agency;
import com.hackathon.hackbe.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {
    UserDto agency;
    UserDto client;
    List<MessageDto> messages;
}
