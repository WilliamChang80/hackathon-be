package com.hackathon.hackbe.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgencyDto {
    private Long id;
    private String name;

    private String description;

    private Double rating;

    private String phoneNumber;
}
