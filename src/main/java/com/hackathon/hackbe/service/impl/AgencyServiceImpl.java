package com.hackathon.hackbe.service.impl;

import com.hackathon.hackbe.dto.entity.AgencyDto;
import com.hackathon.hackbe.dto.request.AgencyRequest;
import com.hackathon.hackbe.dto.request.ClientRequest;
import com.hackathon.hackbe.entity.Agency;
import com.hackathon.hackbe.entity.ClientType;
import com.hackathon.hackbe.entity.User;
import com.hackathon.hackbe.repository.AgencyRepository;
import com.hackathon.hackbe.repository.UserRepository;
import com.hackathon.hackbe.service.AgencyService;
import com.hackathon.hackbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgencyServiceImpl implements AgencyService {

    AgencyRepository agencyRepository;
    UserRepository userRepository;

    @Autowired
    public AgencyServiceImpl(AgencyRepository agencyRepository,
                             UserRepository userRepository) {
        this.agencyRepository = agencyRepository;
        this.userRepository = userRepository;
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

    @Override
    public List<AgencyDto> getAgencyRecommendation(ClientType type) {
        List<Agency> agencyList =  agencyRepository.findAllByClientTypes(type);
        List<AgencyDto> agencies = agencyList.stream().map(
                c -> AgencyDto.builder().description(c.getDescription())
                        .name(c.getName()).phoneNumber(c.getPhoneNumber())
                .rating(c.getRating()).id(c.getId()).build()
        ).collect(Collectors.toList());
        return agencies;
    }

    @Override
    public Agency getAgencyByUserId(Long id) {
        User user = userRepository.getOne(id);
        return agencyRepository.findFirstByUser(user);
    }
}