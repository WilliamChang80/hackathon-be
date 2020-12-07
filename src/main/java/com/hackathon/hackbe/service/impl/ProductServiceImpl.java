package com.hackathon.hackbe.service.impl;

import com.hackathon.hackbe.dto.entity.ProductDto;
import com.hackathon.hackbe.dto.request.ProductRequest;
import com.hackathon.hackbe.entity.Agency;
import com.hackathon.hackbe.entity.ClientType;
import com.hackathon.hackbe.entity.Product;
import com.hackathon.hackbe.repository.AgencyRepository;
import com.hackathon.hackbe.repository.ProductRepository;
import com.hackathon.hackbe.service.AgencyService;
import com.hackathon.hackbe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    AgencyRepository agencyRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, AgencyRepository agencyRepository) {
        this.productRepository = productRepository;
        this.agencyRepository = agencyRepository;
    }

    @Override
    public List<ProductDto> getServices() {
        List<Product> ps = productRepository.findAll();
        List<ProductDto> products = ps.stream().map(p -> ProductDto.builder().id(p.getId())
                .name(p.getName()).description(p.getDescription()).priceEnd(p.getPriceEnd())
                .priceStart(p.getPriceStart()).type(p.getType()).build()).collect(Collectors.toList());
        return products;
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product p = productRepository.getOne(productId);
        return ProductDto.builder().id(productId)
                .name(p.getName()).description(p.getDescription()).priceEnd(p.getPriceEnd())
                .priceStart(p.getPriceStart()).type(p.getType()).build();
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.getOne(productId);
        productRepository.delete(product);
    }

    @Override
    public void createProduct(ProductRequest request) {
        Agency agency = new Agency();
        agency.setId(request.getAgencyId());
        Product product = Product.builder().name(request.getName())
                .description(request.getDescription()).priceEnd(request.getPriceEnd())
                .priceStart(request.getPriceStart()).agency(agency).type(request.getType()).build();
        productRepository.save(product);
    }

    @Override
    public void updateProduct(ProductRequest request, Long productId) {
        Product product = productRepository.getOne(productId);
        product.setName(request.getName());
        product.setType(request.getType());
        product.setPriceEnd(request.getPriceEnd());
        product.setDescription(request.getDescription());
        product.setPriceStart(request.getPriceStart());

        productRepository.save(product);
    }

    @Override
    public List<ProductDto> getProductByAgency(Long agencyId) {
        List<Product> ps = productRepository.findAllByAgency_Id(agencyId);
        List<ProductDto> products = ps.stream().map(p -> ProductDto.builder()
                .id(p.getId())
                .name(p.getName()).description(p.getDescription()).priceEnd(p.getPriceEnd())
                .priceStart(p.getPriceStart()).type(p.getType()).build()).collect(Collectors.toList());
        return products;
    }

    @Override
    public List<ProductDto> getProductBySearch(String query) {
        return null;
    }
}
