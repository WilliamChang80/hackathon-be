package com.hackathon.hackbe.dto.response;

import com.hackathon.hackbe.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class ProductResponse {
    List<Product> products;
}
