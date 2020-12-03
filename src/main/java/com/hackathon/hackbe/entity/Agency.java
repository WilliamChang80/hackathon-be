package com.hackathon.hackbe.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Agency extends BaseEntity {

    @OneToOne
    private User user;

    private String name;

    private String desc;

    private Double rating;
}
