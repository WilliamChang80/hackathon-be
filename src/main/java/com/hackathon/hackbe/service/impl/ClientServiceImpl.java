package com.hackathon.hackbe.service.impl;

import com.hackathon.hackbe.dto.request.ClientRequest;
import com.hackathon.hackbe.entity.Client;
import com.hackathon.hackbe.entity.User;
import com.hackathon.hackbe.repository.ClientRepository;
import com.hackathon.hackbe.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public boolean isUserExist(User user) {
        return clientRepository.existsByUser(user);
    }

    @Override
    public void addClientProfile(ClientRequest clientRequest, User user) {
        Client client = Client.builder()
                .clientType(clientRequest.getType())
                .location(clientRequest.getLocation()).name(clientRequest.getName())
                .phoneNumber(clientRequest.getPhoneNumber()).user(user).build();
        clientRepository.save(client);
    }
}
