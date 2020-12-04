package com.hackathon.hackbe.repository;

import com.hackathon.hackbe.entity.ClientType;
import com.hackathon.hackbe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientTypeRepository extends JpaRepository<ClientType, Long> {
}
