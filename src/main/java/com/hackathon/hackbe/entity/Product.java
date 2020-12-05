package com.hackathon.hackbe.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {
    private String name;
    @OneToOne
    private ServiceType type;
    private String description;
    private int priceStart;
    private int priceEnd;

    @OneToOne
    private Agency agency;
}
