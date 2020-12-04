package com.hackathon.hackbe.repository;

import com.hackathon.hackbe.entity.ClientType;
import com.hackathon.hackbe.entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {
}