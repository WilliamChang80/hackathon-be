package com.hackathon.hackbe.service.impl;

import com.hackathon.hackbe.dto.entity.TransactionDetailDto;
import com.hackathon.hackbe.dto.entity.TransactionDto;
import com.hackathon.hackbe.dto.request.ConfirmTransactionRequest;
import com.hackathon.hackbe.dto.request.CreateTransactionRequest;
import com.hackathon.hackbe.dto.request.ReviewRequest;
import com.hackathon.hackbe.dto.request.TermRequest;
import com.hackathon.hackbe.entity.*;
import com.hackathon.hackbe.enums.TransactionStatus;
import com.hackathon.hackbe.repository.*;
import com.hackathon.hackbe.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    TransactionRepository transactionRepository;
    TransactionDetailRepository transactionDetailRepository;
    ReviewRepository reviewRepository;
    AgencyRepository agencyRepository;
    ClientRepository clientRepository;

    @Autowired
    public TransactionServiceImpl
            (TransactionRepository transactionRepository,
             TransactionDetailRepository transactionDetailRepository,
             ReviewRepository reviewRepository,
             AgencyRepository agencyRepository, ClientRepository clientRepository) {
        this.transactionRepository = transactionRepository;
        this.transactionDetailRepository = transactionDetailRepository;
        this.reviewRepository = reviewRepository;
        this.agencyRepository = agencyRepository;
        this.clientRepository = clientRepository;
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
    public void confirmTransaction(ConfirmTransactionRequest request, Long transactionId) {
        Transaction transaction = transactionRepository.getOne(transactionId);
        transaction.setStatus(TransactionStatus.CONFIRMED);
        transaction.setTerm(request.getTerms());
        transactionRepository.save(transaction);
    }

    @Override
    public void updateTransaction(TermRequest request, Long id) {
        Transaction transaction = transactionRepository.getOne(id);
        transaction.setTerm(request.getTerm());
        transactionRepository.save(transaction);
    }

    @Override
    public void payTransaction(Long transactionId) {
        Transaction transaction = transactionRepository.getOne(transactionId);
        transaction.setStatus(TransactionStatus.PAID);
        transactionRepository.save(transaction);
    }

    @Override
    public void closeTransaction(Long transactionId) {
        Transaction transaction = transactionRepository.getOne(transactionId);
        transaction.setStatus(TransactionStatus.CLOSED);
        transactionRepository.save(transaction);
    }

    @Override
    public List<TransactionDto> getTransactionsByAgency(Long agencyId) {
        List<Transaction> t = transactionRepository.findAllByAgency_Id(agencyId);
        List<TransactionDto> transactions = t.stream().map(
                tr -> TransactionDto.builder().id(tr.getId())
                        .status(getTransactionStatus(tr.getStatus()))
                        .details(tr.getTransactionDetails().stream().map(k -> {
                            Product p = k.getService();
                            String sName = p == null ? null : p.getName();
                            Long sId = p == null ? null : p.getId();
                            return TransactionDetailDto.builder().deadline(k.getDeadline())
                                    .price(k.getPrice()).quantity(k.getQuantity())
                                    .serviceId(sId)
                                    .serviceName(sName).term(k.getTerm()).build();
                        }).collect(Collectors.toList())).build()
        ).collect(Collectors.toList());
        return transactions;
    }

    public String getTransactionStatus(TransactionStatus status) {
        Map<TransactionStatus, String> map = new HashMap<>();
        map.put(TransactionStatus.CLOSED, "Closed");
        map.put(TransactionStatus.WAITING_CONFIRMATION, "Waiting confirmation");
        map.put(TransactionStatus.CONFIRMED, "Confirmed");
        map.put(TransactionStatus.PAID, "Paid");
        map.put(TransactionStatus.REVIEWED, "Reviewed");
        return map.get(status);
    }

    @Override
    public List<TransactionDto> getTransactionByClient(Long clientId) {
        List<Transaction> t = transactionRepository.findAllByClient_Id(clientId);
        List<TransactionDto> transactions = t.stream().map(
                tr -> TransactionDto.builder().id(tr.getId())
                        .status(getTransactionStatus(tr.getStatus()))
                        .details(tr.getTransactionDetails().stream().map(k -> {
                            Product p = k.getService();
                            String sName = p == null ? null : p.getName();
                            Long sId = p == null ? null : p.getId();
                            return TransactionDetailDto.builder().deadline(k.getDeadline())
                                    .price(k.getPrice()).quantity(k.getQuantity())
                                    .serviceId(sId)
                                    .serviceName(sName).term(k.getTerm()).build();
                        }).collect(Collectors.toList())).build()
        ).collect(Collectors.toList());
        return transactions;
    }

    @Override
    public void reviewTransaction(Long id, ReviewRequest request) {
        Transaction transaction = transactionRepository.getOne(id);
        transaction.setStatus(TransactionStatus.REVIEWED);
        transactionRepository.save(transaction);
        Review review = Review.builder().description(request.getDescription())
                .rating(request.getRating()).transaction(transaction).build();
        reviewRepository.save(review);
        Double ratingTotal = reviewRepository.getAvg(transaction.getAgency().getId());
        //update client rating
        Client client = transaction.getClient();
        client.setRating(ratingTotal);
        clientRepository.save(client);
    }
}
