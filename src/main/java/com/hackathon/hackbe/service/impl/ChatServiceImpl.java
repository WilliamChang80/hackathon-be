package com.hackathon.hackbe.service.impl;

import com.hackathon.hackbe.dto.entity.MessageDto;
import com.hackathon.hackbe.dto.entity.UserDto;
import com.hackathon.hackbe.dto.request.ChatRequest;
import com.hackathon.hackbe.dto.request.MessageRequest;
import com.hackathon.hackbe.dto.response.MessageResponse;
import com.hackathon.hackbe.entity.*;
import com.hackathon.hackbe.repository.*;
import com.hackathon.hackbe.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ChatServiceImpl implements ChatService {

    ChatRepository chatRepository;
    MessageRepository messageRepository;
    UserRepository userRepository;
    AgencyRepository agencyRepository;
    ClientRepository clientRepository;

    @Autowired
    public ChatServiceImpl(ChatRepository chatRepository, MessageRepository messageRepository
            , UserRepository userRepository, AgencyRepository agencyRepository, ClientRepository clientRepository) {
        this.chatRepository = chatRepository;
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
        this.agencyRepository = agencyRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public void createChat(ChatRequest request) {
        User admin = userRepository.getOne((long) 1);
        Chat chat = Chat.builder().agency(request.getAgency())
                .client(request.getClient()).admin(admin).build();
        chatRepository.save(chat);
    }

    @Override
    public void sendMessage(Long id, MessageRequest request) {
        Message message = Message.builder().message(request.getMessage())
                .user(request.getSender()).build();
        Chat chat = chatRepository.getOne(id);
        chat.getMessages().add(message);
        messageRepository.save(message);
        chatRepository.save(chat);
    }

    @Override
    public MessageResponse getMessageByChat(Long id) {
        Chat chat = chatRepository.getOne(id);
        Agency agency = chat.getAgency();
        Client client = chat.getClient();
        MessageResponse response = MessageResponse.builder()
                .agency(UserDto.builder().id(agency.getId()).name(agency.getName()).build())
                .client(UserDto.builder().id(client.getId()).name(client.getName()).build())
                .messages(chat.getMessages().stream().map(
                        c -> {
                            String name;
                            if (chat.getAgency().getUser().getId().equals(c.getUser().getId())) {
                                name = chat.getAgency().getName();
                            } else if (chat.getClient().getUser().getId().equals(c.getUser().getId())) {
                                name = chat.getClient().getName();
                            } else name = "Admin";
                            return MessageDto.builder().date(c.getCreatedAt()).message(c.getMessage())
                                    .name(name).build();
                        }).collect(Collectors.toList())
                ).build();
        return response;
    }
}
