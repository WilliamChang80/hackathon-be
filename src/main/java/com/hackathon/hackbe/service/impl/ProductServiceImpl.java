package com.hackathon.hackbe.service.impl;

import com.hackathon.hackbe.dto.entity.AgencyDto;
import com.hackathon.hackbe.dto.entity.ProductDto;
import com.hackathon.hackbe.dto.request.ProductRequest;
import com.hackathon.hackbe.dto.response.SearchResponse;
import com.hackathon.hackbe.entity.*;
import com.hackathon.hackbe.repository.AgencyRepository;
import com.hackathon.hackbe.repository.ClientRepository;
import com.hackathon.hackbe.repository.ProductRepository;
import com.hackathon.hackbe.repository.ServiceTypeRepository;
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
    ServiceTypeRepository serviceTypeRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, AgencyRepository agencyRepository,
                              ServiceTypeRepository serviceTypeRepository) {
        this.productRepository = productRepository;
        this.agencyRepository = agencyRepository;
        this.serviceTypeRepository = serviceTypeRepository;

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
        Agency agency  = agencyRepository.getOne(p.getAgency().getId());
        return ProductDto.builder().id(productId)
                .name(p.getName()).description(p.getDescription()).priceEnd(p.getPriceEnd())
                .priceStart(p.getPriceStart()).type(p.getType()).agencyId(agency.getId()).build();
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
                .agencyId(agencyId)
                .name(p.getName()).description(p.getDescription()).priceEnd(p.getPriceEnd())
                .priceStart(p.getPriceStart()).type(p.getType()).build()).collect(Collectors.toList());
        return products;
    }

    @Override
    public SearchResponse getProductBySearch(String query) {
        List<ServiceType> serviceTypes = serviceTypeRepository.findAllByNameContains(query);
        List<Product> products = productRepository.findAllByNameContains(query);
        List<Agency> agencies = agencyRepository.findAllByNameContains(query);
        SearchResponse response = SearchResponse.builder().products(products.stream().map(p -> ProductDto.builder()
                .id(p.getId())
                .name(p.getName()).description(p.getDescription()).priceEnd(p.getPriceEnd())
                .priceStart(p.getPriceStart()).type(p.getType()).build()).collect(Collectors.toList())).agencies(
                        agencies.stream().map(c -> AgencyDto.builder().description(c.getDescription())
                                .name(c.getName()).phoneNumber(c.getPhoneNumber())
                                .rating(c.getRating()).id(c.getId()).build()
                        ).collect(Collectors.toList())).serviceTypes(serviceTypes).build();
        return response;
    }

    @Override
    public List<ProductDto> getProductByServiceId(Long id) {
        ServiceType serviceType = serviceTypeRepository.getOne(id);
        List<Product> ps = productRepository.findAllByType(serviceType);
        List<ProductDto> products = ps.stream().map(p -> ProductDto.builder()
                .id(p.getId())
                .name(p.getName()).description(p.getDescription()).priceEnd(p.getPriceEnd())
                .priceStart(p.getPriceStart()).type(p.getType()).build()).collect(Collectors.toList());
        return products;
    }
}
