package com.hackathon.hackbe.service;

import com.hackathon.hackbe.dto.request.ChatRequest;
import com.hackathon.hackbe.dto.request.MessageRequest;
import com.hackathon.hackbe.dto.response.ChatResponse;
import com.hackathon.hackbe.dto.response.MessageResponse;

import java.util.List;

public interface ChatService {

    void createChat(ChatRequest request);
    void sendMessage(Long id, MessageRequest request);

    MessageResponse getMessageByChat(Long id);

    List<ChatResponse> getChatByClient(Long id);

    List<ChatResponse> getChatByAgency(Long id);
}
