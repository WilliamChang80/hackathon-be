package com.hackathon.hackbe.service;

import com.hackathon.hackbe.dto.entity.AgencyDto;
import com.hackathon.hackbe.dto.request.ClientRequest;
import com.hackathon.hackbe.entity.Client;
import com.hackathon.hackbe.entity.User;

public interface ClientService {
    boolean isUserExist(User user);

    void addClientProfile(ClientRequest clientRequest, User user);

    Client getClientByUserId(Long userId);
}
