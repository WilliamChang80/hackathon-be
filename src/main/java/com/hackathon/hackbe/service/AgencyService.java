package com.hackathon.hackbe.service;

import com.hackathon.hackbe.dto.request.AgencyRequest;
import com.hackathon.hackbe.dto.request.ClientRequest;
import com.hackathon.hackbe.entity.User;

public interface AgencyService {
    boolean isUserExist(User user);

    void addAgencyProfile(AgencyRequest agencyRequest, User user);
}
