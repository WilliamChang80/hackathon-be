package com.hackathon.hackbe.repository;

import com.hackathon.hackbe.entity.Transaction;
import com.hackathon.hackbe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByAgency_Id(Long agencyId);
    List<Transaction> findAllByClient_Id(Long clientId);
}
