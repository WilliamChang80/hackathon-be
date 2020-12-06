package com.hackathon.hackbe.repository;

import com.hackathon.hackbe.entity.Agency;
import com.hackathon.hackbe.entity.ClientType;
import com.hackathon.hackbe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {
    boolean existsByUser(User user);

    List<Agency> findAllByClientTypes(ClientType type);

    Agency findFirstByUser(User user);
}
