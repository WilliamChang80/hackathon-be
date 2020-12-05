package com.hackathon.hackbe.repository;

import com.hackathon.hackbe.entity.Transaction;
import com.hackathon.hackbe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
