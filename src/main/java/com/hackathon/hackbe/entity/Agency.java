package com.hackathon.hackbe.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Agency extends BaseEntity {

    @OneToOne
    private User user;

    private String name;

    private String description;

    private Double rating;

    private String phoneNumber;

    @OneToMany
    private List<ClientType> clientTypes;
}
