package com.hackathon.hackbe.dto.response;


import com.hackathon.hackbe.dto.entity.AgencyDto;
import com.hackathon.hackbe.dto.entity.ProductDto;
import com.hackathon.hackbe.entity.Product;
import com.hackathon.hackbe.entity.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class SearchResponse {
    List<AgencyDto> agencies;
    List<ServiceType> serviceTypes;
    List<ProductDto> products;
}
