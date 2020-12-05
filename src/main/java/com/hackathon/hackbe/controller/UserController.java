package com.hackathon.hackbe.controller;

import com.hackathon.hackbe.dto.request.AgencyRequest;
import com.hackathon.hackbe.dto.request.ClientRequest;
import com.hackathon.hackbe.dto.response.BaseResponse;
import com.hackathon.hackbe.entity.User;
import com.hackathon.hackbe.service.AgencyService;
import com.hackathon.hackbe.service.ClientService;
import com.hackathon.hackbe.service.UserService;
import com.hackathon.hackbe.url.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


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

    private boolean updatedUsernameValid(String email, Long userId) {
        User user = userService.getUserById(userId);
        if (!email.equals(user.getEmail())) {
            User userTemp = userService.getUserByEmail(email);
            return userTemp == null || userTemp.getId().equals(userId);
        }
        return true;
    }


    @PostMapping(Url.ADD_AGENCY_PROFILE_URL)
    private BaseResponse addAgencyProfile(@RequestBody AgencyRequest agencyRequest) {
        User user = userService.getUserById(agencyRequest.getUserId());
        agencyService.addAgencyProfile(agencyRequest, user);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }

    @PostMapping(Url.ADD_CLIENT_PROFILE_URL)
    private BaseResponse addClientProfile(@RequestBody ClientRequest clientRequest) {
        User user = userService.getUserById(clientRequest.getUserId());
        clientService.addClientProfile(clientRequest, user);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }
}
