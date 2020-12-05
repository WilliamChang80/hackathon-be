package com.hackathon.hackbe.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client extends BaseEntity{

    @OneToOne
    private User user;

    private String name;

    private String location;

    private String phoneNumber;

    @OneToOne
    private ClientType clientType;
}
