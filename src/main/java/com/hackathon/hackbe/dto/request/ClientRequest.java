package com.hackathon.hackbe.dto.request;

import com.hackathon.hackbe.entity.ClientType;
import lombok.*;

import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {

    private Long userId;
    private String name;
    private String location;

    @OneToOne
    private ClientType type;

    private String phoneNumber;
}
