package com.hackathon.hackbe.service.impl;

import com.hackathon.hackbe.dto.request.CreateTransactionRequest;
import com.hackathon.hackbe.entity.Transaction;
import com.hackathon.hackbe.entity.TransactionDetail;
import com.hackathon.hackbe.enums.TransactionStatus;
import com.hackathon.hackbe.repository.TransactionDetailRepository;
import com.hackathon.hackbe.repository.TransactionRepository;
import com.hackathon.hackbe.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    TransactionRepository transactionRepository;
    TransactionDetailRepository transactionDetailRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  TransactionDetailRepository transactionDetailRepository) {
        this.transactionRepository = transactionRepository;
        this.transactionDetailRepository = transactionDetailRepository;
    }

    @Override
    public void createTransaction(CreateTransactionRequest request) {
        List<TransactionDetail> details = request.getServices();
        for (TransactionDetail detail : details) {
            transactionDetailRepository.save(detail);
        }

        Transaction transaction = Transaction.builder().agency(request.getAgency())
                .client(request.getClient())
                .status(TransactionStatus.WAITING_CONFIRMATION)
                .transactionDetails(request.getServices()).build();
        transactionRepository.save(transaction);
    }

    @Override
    public void confirmTransaction(Long transactionId) {
        Transaction transaction = transactionRepository.getOne(transactionId);
        transaction.setStatus(TransactionStatus.CONFIRMED);
    }

    @Override
    public void updateTransaction(CreateTransactionRequest request, Long id) {
        Transaction transaction = transactionRepository.getOne(id);
        for (TransactionDetail detail : request.getServices()) {
            TransactionDetail td = transactionDetailRepository.getOne(detail.getId());
            td.setDeadline(detail.getDeadline());
            td.setPrice(detail.getPrice());
            td.setQuantity(detail.getQuantity());
            td.setTerm(detail.getTerm());
            transactionDetailRepository.save(td);
        }
    }
}
