package com.hackathon.hackbe.service;

import com.hackathon.hackbe.dto.entity.AgencyDto;
import com.hackathon.hackbe.dto.request.AgencyRequest;
import com.hackathon.hackbe.dto.request.ClientRequest;
import com.hackathon.hackbe.entity.Agency;
import com.hackathon.hackbe.entity.ClientType;
import com.hackathon.hackbe.entity.User;

import java.util.List;

public interface AgencyService {
    boolean isUserExist(User user);

    void addAgencyProfile(AgencyRequest agencyRequest, User user);

    List<AgencyDto> getAgencyRecommendation(ClientType type);

    Agency getAgencyByUserId(Long id);
}
