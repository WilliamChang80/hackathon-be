package com.hackathon.hackbe.entity;

import com.hackathon.hackbe.enums.TransactionStatus;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Transaction extends BaseEntity{
    @OneToOne
    Client client;

    @OneToOne
    Agency agency;

    TransactionStatus status;

    @OneToMany(fetch = FetchType.LAZY)
    List<TransactionDetail> transactionDetails;

}
