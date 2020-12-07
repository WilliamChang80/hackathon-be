package com.hackathon.hackbe.controller;

import com.hackathon.hackbe.dto.entity.AgencyDto;
import com.hackathon.hackbe.dto.entity.ClientDto;
import com.hackathon.hackbe.dto.request.AgencyRequest;
import com.hackathon.hackbe.dto.request.ClientRequest;
import com.hackathon.hackbe.dto.response.AgencyResponse;
import com.hackathon.hackbe.dto.response.BaseResponse;
import com.hackathon.hackbe.entity.Agency;
import com.hackathon.hackbe.entity.Client;
import com.hackathon.hackbe.entity.User;
import com.hackathon.hackbe.service.AgencyService;
import com.hackathon.hackbe.service.ClientService;
import com.hackathon.hackbe.service.UserService;
import com.hackathon.hackbe.url.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    UserService userService;
    AgencyService agencyService;
    ClientService clientService;

    @Autowired
    public UserController(UserService userService, AgencyService agencyService,
                          ClientService clientService) {
        this.userService = userService;
        this.agencyService = agencyService;
        this.clientService = clientService;
    }

    @GetMapping(Url.GET_AGENCY_RECOMMENDATION)
    public BaseResponse getRecommendationAgency(@PathVariable Long id) {
        Client client = clientService.getClientByUserId(id);
        List<AgencyDto> agencies = agencyService.getAgencyRecommendation(client.getClientType());
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").
                data(AgencyResponse.builder().agencies(agencies).build()).build();
    }


    @GetMapping("/api/agency/{id}")
    public BaseResponse getAgencyById(@PathVariable Long id) {
        Client client = clientService.getClientByUserId(id);
        List<AgencyDto> agencies = agencyService.getAgencyRecommendation(client.getClientType());
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").
                data(AgencyResponse.builder().agencies(agencies).build()).build();
    }

    @PostMapping(Url.ADD_AGENCY_PROFILE_URL)
    public BaseResponse addAgencyProfile(@RequestBody AgencyRequest agencyRequest) {
        User user = userService.getUserById(agencyRequest.getUserId());
        agencyService.addAgencyProfile(agencyRequest, user);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }

    @PostMapping(Url.ADD_CLIENT_PROFILE_URL)
    public BaseResponse addClientProfile(@RequestBody ClientRequest clientRequest) {
        User user = userService.getUserById(clientRequest.getUserId());
        clientService.addClientProfile(clientRequest, user);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }

    @GetMapping("api/user/{id}/client")
    public BaseResponse getClientByUserId(@PathVariable Long id) {
        Client client = clientService.getClientByUserId(id);
        ClientDto clientDto = ClientDto.builder().clientType(client.getClientType())
                .location(client.getLocation()).name(client.getName()).phoneNumber(client.getPhoneNumber())
                .id(client.getId()).build();
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success")
                .data(clientDto).build();
    }

    @GetMapping("api/user/{id}/agency")
    public BaseResponse getAgencyByUserId(@PathVariable Long id) {
        Agency a = agencyService.getAgencyByUserId(id);
        AgencyDto agency = AgencyDto.builder().description(a.getDescription())
                .id(a.getId()).name(a.getName()).phoneNumber(a.getPhoneNumber())
                .rating(a.getRating()).build();
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success")
                .data(agency).build();
    }
}
