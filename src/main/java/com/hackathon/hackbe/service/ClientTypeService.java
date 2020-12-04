package com.hackathon.hackbe.service;

import com.hackathon.hackbe.dto.request.ClientTypeRequest;
import com.hackathon.hackbe.entity.ClientType;
import com.hackathon.hackbe.entity.User;

import java.util.List;

public interface ClientTypeService {
    List<ClientType> getClientTypes();

    void createClientTypes(ClientTypeRequest request);

    void updateClientType(ClientTypeRequest request, Long clientTypeId);

    void deleteClientType(Long clientTypeId);

    ClientType getClientTypeById(Long clientTypeId);
}
