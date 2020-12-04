package com.hackathon.hackbe.service.impl;

import com.hackathon.hackbe.dto.request.AuthRequest;
import com.hackathon.hackbe.dto.response.UserResponse;
import com.hackathon.hackbe.entity.User;
import com.hackathon.hackbe.enums.Role;
import com.hackathon.hackbe.repository.UserRepository;
import com.hackathon.hackbe.service.AgencyService;
import com.hackathon.hackbe.service.ClientService;
import com.hackathon.hackbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    AgencyService agencyService;
    ClientService clientService;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, AgencyService agencyService,
                           ClientService clientService) {
        this.userRepository = userRepository;
        this.agencyService = agencyService;
        this.clientService = clientService;
    }


    @Override
    public void createUser(AuthRequest authRequest) {
        String hashedPassword = BCrypt.hashpw(authRequest.getPassword(), BCrypt.gensalt(10));
        User user = User.builder().email(authRequest.getEmail()).password(hashedPassword).build();
        userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getByEmailEquals(email);

    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public boolean isValidLoginCredentials(String email, String password) {
        User user = userRepository.getByEmailEquals(email);
        if (user == null) {
            return false;
        }
        return BCrypt.checkpw(password, user.getPassword());
    }

    @Override
    public List<Role> getUserRoles(Long userId) {
        List<Role> roles = new ArrayList<>();
        User user = userRepository.getOne(userId);
        boolean isAgencyExist = agencyService.isUserExist(user);
        if (isAgencyExist)
            roles.add(Role.AGENCIES);
        boolean isClientExist = clientService.isUserExist(user);
        if (isClientExist)
            roles.add(Role.CLIENT);

        return roles;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getByEmailEquals(email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                new ArrayList<>());
    }

    private UserResponse convertUserToResponse(User user) {
        return UserResponse.builder().id(user.getId()).email(user.getEmail()).build();
    }


}
