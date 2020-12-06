package com.hackathon.hackbe.controller;

import com.hackathon.hackbe.dto.request.ChatRequest;
import com.hackathon.hackbe.dto.request.MessageRequest;
import com.hackathon.hackbe.dto.response.BaseResponse;
import com.hackathon.hackbe.dto.response.MessageResponse;
import com.hackathon.hackbe.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {

    ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("api/chat")
    public BaseResponse createChat(@RequestBody ChatRequest request) {
        chatService.createChat(request);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }

    @PostMapping("api/chat/{id}/message")
    public BaseResponse sendMessage(@PathVariable Long id,
                                    @RequestBody MessageRequest request) {
        chatService.sendMessage(id, request);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }

    @GetMapping("api/chat/{id}")
    public BaseResponse getMessageByChat(@PathVariable Long id) {
        MessageResponse response =  chatService.getMessageByChat(id);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success")
                .data(response).build();
    }
}
