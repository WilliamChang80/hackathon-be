package com.hackathon.hackbe.dto.request;

import com.hackathon.hackbe.entity.Agency;
import com.hackathon.hackbe.entity.Client;
import com.hackathon.hackbe.entity.TransactionDetail;
import com.hackathon.hackbe.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransactionRequest {
    Agency agency;
    Client client;
    List<TransactionDetail> services;
}
