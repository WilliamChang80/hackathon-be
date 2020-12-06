package com.hackathon.hackbe.service;

import com.hackathon.hackbe.dto.request.ChatRequest;
import com.hackathon.hackbe.dto.request.MessageRequest;
import com.hackathon.hackbe.dto.response.MessageResponse;

public interface ChatService {

    void createChat(ChatRequest request);
    void sendMessage(Long id, MessageRequest request);

    MessageResponse getMessageByChat(Long id);
}
