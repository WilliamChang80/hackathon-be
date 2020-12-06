package com.hackathon.hackbe.controller;

import com.hackathon.hackbe.dto.request.CreateTransactionRequest;
import com.hackathon.hackbe.dto.response.BaseResponse;
import com.hackathon.hackbe.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    //agency set the price and policy
    @PostMapping("/api/transaction/{id}/confirm")
    public BaseResponse confirmTransaction(@PathVariable Long id) {
        transactionService.confirmTransaction(id);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }

    //accept the transaction

    //pay transaction


}
