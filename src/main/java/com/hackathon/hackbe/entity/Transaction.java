package com.hackathon.hackbe.entity;

import com.hackathon.hackbe.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction extends BaseEntity {
    @OneToOne
    private Client client;

    @OneToOne
    private Agency agency;

    private TransactionStatus status;

    @ManyToMany
    private List<TransactionDetail> transactionDetails;

    private String term;
}
