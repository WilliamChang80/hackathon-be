package com.hackathon.hackbe.controller;


import com.hackathon.hackbe.dto.request.ClientTypeRequest;
import com.hackathon.hackbe.dto.request.ServiceTypeRequest;
import com.hackathon.hackbe.dto.response.BaseResponse;
import com.hackathon.hackbe.dto.response.ClientTypeResponse;
import com.hackathon.hackbe.dto.response.ServiceTypeResponse;
import com.hackathon.hackbe.entity.ClientType;
import com.hackathon.hackbe.entity.ServiceType;
import com.hackathon.hackbe.service.ClientTypeService;
import com.hackathon.hackbe.service.ServiceTypeService;
import com.hackathon.hackbe.url.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceTypeController {

    ServiceTypeService serviceTypeService;

    @Autowired
    public ServiceTypeController(ServiceTypeService serviceTypeService) {
        this.serviceTypeService = serviceTypeService;
    }

    @PostMapping(Url.CREATE_SERVICE_TYPE_URL)
    public BaseResponse createServiceType(@RequestBody ServiceTypeRequest request) {
        serviceTypeService.createServiceType(request);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }


    @PostMapping(Url.UPDATE_SERVICE_TYPE_URL)
    public BaseResponse updateServiceType(@RequestBody ClientTypeRequest request, @PathVariable Long id) {
        serviceTypeService.updateServiceType(request, id);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }

    @DeleteMapping(Url.DELETE_SERVICE_TYPE_URL)
    public BaseResponse deleteServiceType(@PathVariable Long id) {
        serviceTypeService.deleteServiceType(id);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }

    @GetMapping(Url.GET_SERVICE_TYPE_BY_ID_URL)
    public BaseResponse getServiceTypeById(@PathVariable Long id) {
        ServiceType serviceType = serviceTypeService.getServiceTypeById(id);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").data(
                ClientType.builder().name(serviceType.getName()).build()
        ).build();
    }


    @GetMapping(Url.GET_SERVICE_TYPES_URL)
    public BaseResponse getServiceTypes() {
        List<ServiceType> serviceTypes = serviceTypeService.getServiceTypes();
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").data(
                ServiceTypeResponse.builder().types(serviceTypes).build()
        ).build();
    }
}

