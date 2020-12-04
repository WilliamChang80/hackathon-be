package com.hackathon.hackbe.repository;

import com.hackathon.hackbe.entity.Client;
import com.hackathon.hackbe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    boolean existsByUser(User user);
}
