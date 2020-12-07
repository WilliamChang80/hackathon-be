package com.hackathon.hackbe.controller;

import com.hackathon.hackbe.dto.entity.ProductDto;
import com.hackathon.hackbe.dto.request.ProductRequest;
import com.hackathon.hackbe.dto.response.BaseResponse;
import com.hackathon.hackbe.entity.Agency;
import com.hackathon.hackbe.entity.Product;
import com.hackathon.hackbe.service.AgencyService;
import com.hackathon.hackbe.service.ProductService;
import com.hackathon.hackbe.url.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ProductController {

    ProductService productService;

    AgencyService agencyService;

    @Autowired
    public ProductController(ProductService productService, AgencyService agencyService) {
        this.productService = productService;
        this.agencyService = agencyService;
    }

    @GetMapping(Url.GET_SERVICES_URL)
    public BaseResponse getServices() {
        List<ProductDto> products = productService.getServices();
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").data(products).build();
    }

    @GetMapping(Url.GET_SERVICE_BY_ID_URL)
    public BaseResponse getService(@PathVariable Long id) {
        ProductDto product = productService.getProductById(id);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").data(product).build();
    }

    @DeleteMapping(Url.DELETE_SERVICE_URL)
    public BaseResponse deleteService(@PathVariable Long id) {
        productService.deleteProduct(id);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }


    @PostMapping(Url.CREATE_SERVICE_URL)
    public BaseResponse createService(@RequestBody ProductRequest request) {
        productService.createProduct(request);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }

    @GetMapping(Url.GET_SERVICE_BY_AGENCY_ID_URL)
    public BaseResponse getServiceByAgency(@PathVariable Long id) {
        List<ProductDto> products = productService.getProductByAgency(id);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success")
                .data(products).build();
    }


    @PostMapping(Url.UPDATE_SERVICE_URL)
    public BaseResponse updateService(@RequestBody ProductRequest request, @PathVariable Long id) {
        productService.updateProduct(request, id);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success").build();
    }

    @GetMapping("api/services/search")
    public BaseResponse searchWithKeyword(@RequestParam String query) {
        List<ProductDto> products = productService.getProductBySearch(query);
        return BaseResponse.builder().code(HttpStatus.OK.value()).message("Success")
                .data(products).build();
    }
}
