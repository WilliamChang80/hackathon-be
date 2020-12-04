package com.hackathon.hackbe.service.impl;

import com.hackathon.hackbe.entity.User;
import com.hackathon.hackbe.repository.AgencyRepository;
import com.hackathon.hackbe.service.AgencyService;
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
}