package com.hackathon.hackbe.controller;

import com.hackathon.hackbe.dto.entity.TransactionDto;
import com.hackathon.hackbe.dto.request.CreateTransactionRequest;
import com.hackathon.hackbe.dto.response.BaseResponse;
import com.hackathon.hackbe.entity.Transaction;
import com.hackathon.hackbe.service.TransactionService;
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
    public BaseResponse updateTransaction(@RequestBody CreateTransactionRequest request, @PathVariable Long id) {
        transactionService.updateTransaction(request,id);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }

    //accept the transaction
    @PostMapping("/api/transaction/{id}/confirm")
    public BaseResponse confirmTransaction(@PathVariable Long id) {
        transactionService.confirmTransaction(id);
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
}
