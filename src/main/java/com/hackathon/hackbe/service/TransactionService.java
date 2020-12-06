package com.hackathon.hackbe.service;

import com.hackathon.hackbe.dto.request.CreateTransactionRequest;

public interface TransactionService {

    void createTransaction(CreateTransactionRequest request);

    void confirmTransaction(Long transactionId);

    void updateTransaction(CreateTransactionRequest request, Long id);
}
