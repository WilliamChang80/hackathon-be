package com.hackathon.hackbe.repository;

import com.hackathon.hackbe.entity.ServiceType;
import com.hackathon.hackbe.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, Long> {
}
