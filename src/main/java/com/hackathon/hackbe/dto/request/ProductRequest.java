package com.hackathon.hackbe.dto.request;

import com.hackathon.hackbe.entity.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String name;
    private Long agencyId;
    private String description;
    private int priceStart;
    private int priceEnd;
    private ServiceType type;
}
