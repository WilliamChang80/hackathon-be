package com.hackathon.hackbe.dto.entity;

import com.hackathon.hackbe.entity.ClientType;
import com.hackathon.hackbe.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private Long id;

    private String name;

    private String location;

    private String phoneNumber;

    private ClientType clientType;
}
