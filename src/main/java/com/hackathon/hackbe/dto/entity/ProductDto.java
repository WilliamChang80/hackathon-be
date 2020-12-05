package com.hackathon.hackbe.dto.entity;

import com.hackathon.hackbe.entity.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String name;
    private ServiceType type;
    private String description;
    private int priceStart;
    private int priceEnd;
}
