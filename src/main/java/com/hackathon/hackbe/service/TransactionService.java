package com.hackathon.hackbe.service;

import com.hackathon.hackbe.dto.entity.TransactionDetailDto;
import com.hackathon.hackbe.dto.entity.TransactionDto;
import com.hackathon.hackbe.dto.request.CreateTransactionRequest;
import com.hackathon.hackbe.entity.Transaction;

import java.util.List;

public interface TransactionService {

    void createTransaction(CreateTransactionRequest request);

    void confirmTransaction(Long transactionId);

    void updateTransaction(CreateTransactionRequest request, Long id);

    void payTransaction(Long transactionId);

    void closeTransaction(Long transactionId);

    List<TransactionDto> getTransactionsByAgency(Long agencyId);

    List<TransactionDto> getTransactionByClient(Long clientId);
}
