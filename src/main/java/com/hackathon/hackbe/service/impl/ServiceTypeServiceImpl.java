package com.hackathon.hackbe.service.impl;

import com.hackathon.hackbe.dto.request.ClientTypeRequest;
import com.hackathon.hackbe.dto.request.ServiceTypeRequest;
import com.hackathon.hackbe.entity.ServiceType;
import com.hackathon.hackbe.repository.ServiceTypeRepository;
import com.hackathon.hackbe.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    ServiceTypeRepository serviceTypeRepository;

    @Autowired
    public ServiceTypeServiceImpl(ServiceTypeRepository serviceTypeRepository) {
        this.serviceTypeRepository = serviceTypeRepository;
    }


    @Override
    public List<ServiceType> getServiceTypes() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public void createServiceType(ServiceTypeRequest request) {
        ServiceType serviceType = ServiceType.builder().name(request.getName()).build();
        serviceTypeRepository.save(serviceType);
    }

    @Override
    public void updateServiceType(ClientTypeRequest request, Long serviceTypeId) {
        ServiceType serviceType = getServiceTypeById(serviceTypeId);
        serviceType.setName(request.getName());
        serviceTypeRepository.save(serviceType);
    }

    @Override
    public void deleteServiceType(Long serviceTypeId) {
        ServiceType serviceType = getServiceTypeById(serviceTypeId);
        serviceTypeRepository.delete(serviceType);
    }

    @Override
    public ServiceType getServiceTypeById(Long serviceTypeId) {
        return serviceTypeRepository.getOne(serviceTypeId);
    }
}
