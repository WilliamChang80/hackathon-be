package com.hackathon.hackbe.repository;

import com.hackathon.hackbe.entity.Client;
import com.hackathon.hackbe.entity.Review;
import com.hackathon.hackbe.entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT AVG(a.rating)\n" +
            "FROM review\n" +
            "JOIN transaction t on review.transaction_id = t.id\n" +
            "JOIN agency a on t.agency_id = a.id\n" +
            "WHERE agency_id = ?1", nativeQuery = true)
    Double getAvg(Long agencyId);
}
