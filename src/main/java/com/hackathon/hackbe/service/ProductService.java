package com.hackathon.hackbe.service;

import com.hackathon.hackbe.dto.entity.ProductDto;
import com.hackathon.hackbe.dto.request.ProductRequest;
import com.hackathon.hackbe.entity.ClientType;
import com.hackathon.hackbe.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> getServices();
    ProductDto getProductById(Long productId);
    void deleteProduct(Long productId);
    void createProduct(ProductRequest request);
    void updateProduct(ProductRequest request, Long productId);
    List<ProductDto> getProductByAgency(Long agencyId);
    List<ProductDto> getProductBySearch(String query);
}
