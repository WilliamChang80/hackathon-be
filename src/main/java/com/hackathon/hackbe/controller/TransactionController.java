package com.hackathon.hackbe.controller;

import com.hackathon.hackbe.dto.entity.TransactionDto;
import com.hackathon.hackbe.dto.request.ConfirmTransactionRequest;
import com.hackathon.hackbe.dto.request.CreateTransactionRequest;
import com.hackathon.hackbe.dto.request.ReviewRequest;
import com.hackathon.hackbe.dto.request.TermRequest;
import com.hackathon.hackbe.dto.response.BaseResponse;
import com.hackathon.hackbe.entity.Transaction;
import com.hackathon.hackbe.service.TransactionService;
import com.mysql.cj.ServerPreparedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {


    TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    //user buy items
    @PostMapping("api/transaction/checkout")
    public BaseResponse checkoutTransaction(@RequestBody CreateTransactionRequest request) {
        transactionService.createTransaction(request);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }

    @PostMapping("/api/transaction/{id}/update")
    public BaseResponse updateTransaction(@RequestBody TermRequest request, @PathVariable Long id) {
        transactionService.updateTransaction(request,id);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }

    //accept the transaction
    @PostMapping("/api/transaction/{id}/confirm")
    public BaseResponse confirmTransaction(@RequestBody ConfirmTransactionRequest request,
                                           @PathVariable Long id) {
        transactionService.confirmTransaction(request, id);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }

    //pay transaction
    @PostMapping("/api/transaction/{id}/pay")
    public BaseResponse payTransaction(@PathVariable Long id) {
        transactionService.payTransaction(id);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }

    @PostMapping("/api/transaction/{id}/close")
    public BaseResponse closeTransaction(@PathVariable Long id) {
        transactionService.closeTransaction(id);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }

    @GetMapping("/api/transaction/agency/{id}")
    public BaseResponse getTransactionsByAgency(@PathVariable Long id) {
        List<TransactionDto> transactions = transactionService.getTransactionsByAgency(id);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success")
                .data(transactions).build();
    }

    @GetMapping("/api/transaction/client/{id}")
    public BaseResponse getTransactionsByClient(@PathVariable Long id) {
        List<TransactionDto> transactions = transactionService.getTransactionByClient(id);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success")
                .data(transactions).build();
    }

    @PostMapping("/api/transaction/{id}/review")
    public BaseResponse reviewTransaction(@PathVariable Long id, @RequestBody
                                          ReviewRequest request) {
        transactionService.reviewTransaction(id, request);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }

}
