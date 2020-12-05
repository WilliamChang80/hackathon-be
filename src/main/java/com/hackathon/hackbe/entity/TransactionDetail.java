package com.hackathon.hackbe.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class TransactionDetail extends BaseEntity {

    @OneToOne
    Product service;

    Integer quantity;

    Integer price;

    @OneToMany
    List<Term> terms;
}
