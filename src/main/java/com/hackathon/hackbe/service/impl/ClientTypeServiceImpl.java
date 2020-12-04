package com.hackathon.hackbe.service.impl;

import com.hackathon.hackbe.dto.request.ClientTypeRequest;
import com.hackathon.hackbe.entity.Client;
import com.hackathon.hackbe.entity.ClientType;
import com.hackathon.hackbe.repository.ClientTypeRepository;
import com.hackathon.hackbe.service.ClientTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientTypeServiceImpl implements ClientTypeService {

    ClientTypeRepository clientTypeRepository;

    @Autowired
    public ClientTypeServiceImpl(ClientTypeRepository clientTypeRepository) {
        this.clientTypeRepository = clientTypeRepository;
    }

    @Override
    public List<ClientType> getClientTypes() {
        return clientTypeRepository.findAll();
    }

    @Override
    public void createClientTypes(ClientTypeRequest request) {
        ClientType clientType = ClientType.builder().name(request.getName()).build();
        clientTypeRepository.save(clientType);
    }

    @Override
    public void updateClientType(ClientTypeRequest request, Long clientTypeId) {
        ClientType clientType = getClientTypeById(clientTypeId);
        clientType.setName(request.getName());
        clientTypeRepository.save(clientType);
    }

    @Override
    public void deleteClientType(Long clientTypeId) {
        ClientType clientType = getClientTypeById(clientTypeId);
        clientTypeRepository.delete(clientType);
    }

    @Override
    public ClientType getClientTypeById(Long clientTypeId) {
        return clientTypeRepository.getOne(clientTypeId);
    }
}
