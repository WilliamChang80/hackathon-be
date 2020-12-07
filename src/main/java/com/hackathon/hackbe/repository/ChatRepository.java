package com.hackathon.hackbe.repository;

import com.hackathon.hackbe.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findAllByClient_Id(Long clientId);
    List<Chat> findAllByAgency_Id(Long agencyId);
}
