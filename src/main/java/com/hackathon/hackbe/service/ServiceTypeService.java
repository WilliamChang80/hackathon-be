package com.hackathon.hackbe.service;

import com.hackathon.hackbe.dto.request.ClientTypeRequest;
import com.hackathon.hackbe.dto.request.ServiceTypeRequest;
import com.hackathon.hackbe.entity.ClientType;
import com.hackathon.hackbe.entity.ServiceType;

import java.util.List;

public interface ServiceTypeService {
    List<ServiceType> getServiceTypes();

    void createServiceType(ServiceTypeRequest request);

    void updateServiceType(ClientTypeRequest request, Long serviceTypeId);

    void deleteServiceType(Long serviceTypeId);

    ServiceType getServiceTypeById(Long serviceTypeId);
}
