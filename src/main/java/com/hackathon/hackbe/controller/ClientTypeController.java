package com.hackathon.hackbe.controller;

import com.hackathon.hackbe.dto.request.ClientTypeRequest;
import com.hackathon.hackbe.dto.response.BaseResponse;
import com.hackathon.hackbe.dto.response.ClientTypeResponse;
import com.hackathon.hackbe.entity.ClientType;
import com.hackathon.hackbe.service.ClientTypeService;
import com.hackathon.hackbe.url.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientTypeController {

    ClientTypeService clientTypeService;

    @Autowired
    public ClientTypeController(ClientTypeService clientTypeService) {
        this.clientTypeService = clientTypeService;
    }

    @PostMapping(Url.CREATE_CLIENT_TYPE_URL)
    public BaseResponse createClientTypes(@RequestBody ClientTypeRequest request) {
        clientTypeService.createClientTypes(request);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }


    @PostMapping(Url.UPDATE_CLIENT_TYPE_URL)
    public BaseResponse updateClientType(@RequestBody ClientTypeRequest request, @PathVariable Long id) {
        clientTypeService.updateClientType(request, id);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }

    @DeleteMapping(Url.DELETE_CLIENT_TYPE_URL)
    public BaseResponse deleteClientType(@PathVariable Long id) {
        clientTypeService.deleteClientType(id);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }

    @GetMapping(Url.GET_CLIENT_TYPE_BY_ID_URL)
    public BaseResponse getClientTypeById(@PathVariable Long id) {
        ClientType clientType = clientTypeService.getClientTypeById(id);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").data(
                ClientType.builder().name(clientType.getName()).build()
        ).build();
    }


    @GetMapping(Url.GET_CLIENT_TYPES_URL)
    public BaseResponse getClientTypes() {
        List<ClientType> clientTypes = clientTypeService.getClientTypes();
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").data(
                ClientTypeResponse.builder().types(clientTypes).build()
        ).build();
    }
}
