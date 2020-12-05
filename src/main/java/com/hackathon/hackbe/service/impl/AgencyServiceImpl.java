package com.hackathon.hackbe.service.impl;

import com.hackathon.hackbe.dto.request.AgencyRequest;
import com.hackathon.hackbe.dto.request.ClientRequest;
import com.hackathon.hackbe.entity.Agency;
import com.hackathon.hackbe.entity.User;
import com.hackathon.hackbe.repository.AgencyRepository;
import com.hackathon.hackbe.service.AgencyService;
import com.hackathon.hackbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgencyServiceImpl implements AgencyService {

    AgencyRepository agencyRepository;

    @Autowired
    public AgencyServiceImpl(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public boolean isUserExist(User user) {
        return agencyRepository.existsByUser(user);
    }

    @Override
    public void addAgencyProfile(AgencyRequest agencyRequest, User user) {
        Agency agency = Agency.builder().description(agencyRequest.getName())
                .clientTypes(agencyRequest.getClientTypes()).name(agencyRequest.getName())
                .phoneNumber(agencyRequest.getPhoneNumber()).rating(agencyRequest.getRating())
                .user(user).build();
        agencyRepository.save(agency);
    }
}