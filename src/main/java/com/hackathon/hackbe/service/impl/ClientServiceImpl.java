package com.hackathon.hackbe.service.impl;

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
}
