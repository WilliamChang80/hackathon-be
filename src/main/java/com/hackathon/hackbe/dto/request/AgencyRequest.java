package com.hackathon.hackbe.dto.request;


import com.hackathon.hackbe.entity.Agency;
import com.hackathon.hackbe.entity.ClientType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class AgencyRequest {
    private String description;
    private double rating;
    private Long userId;
    private List<ClientType> clientTypes;
    private String name;
    private String phoneNumber;
}
