package com.hackathon.hackbe.repository;

import com.hackathon.hackbe.entity.Agency;
import com.hackathon.hackbe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {
    boolean existsByUser(User user);
}
