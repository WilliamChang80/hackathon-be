package com.hackathon.hackbe.repository;

import com.hackathon.hackbe.entity.Product;
import com.hackathon.hackbe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByAgency_Id(Long id);
}
