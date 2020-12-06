package com.hackathon.hackbe.dto.request;

import com.hackathon.hackbe.entity.Agency;
import com.hackathon.hackbe.entity.Client;
import com.hackathon.hackbe.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {
    Transaction transaction;
    String description;
    Double rating;
}
