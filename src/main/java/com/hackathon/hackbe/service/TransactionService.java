package com.hackathon.hackbe.service;

import com.hackathon.hackbe.dto.entity.TransactionDetailDto;
import com.hackathon.hackbe.dto.entity.TransactionDto;
import com.hackathon.hackbe.dto.request.ConfirmTransactionRequest;
import com.hackathon.hackbe.dto.request.CreateTransactionRequest;
import com.hackathon.hackbe.dto.request.ReviewRequest;
import com.hackathon.hackbe.dto.request.TermRequest;
import com.hackathon.hackbe.entity.Transaction;

import java.util.List;

public interface TransactionService {

    void createTransaction(CreateTransactionRequest request);

    void confirmTransaction(ConfirmTransactionRequest request, Long transactionId);

    void updateTransaction(TermRequest request, Long id);

    void payTransaction(Long transactionId);

    void closeTransaction(Long transactionId);

    List<TransactionDto> getTransactionsByAgency(Long agencyId);

    List<TransactionDto> getTransactionByClient(Long clientId);

    void reviewTransaction(Long id, ReviewRequest request);
}
