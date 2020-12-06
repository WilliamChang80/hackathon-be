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
public class Review extends BaseEntity{
    String description;
    Double rating;

    @OneToOne
    Transaction transaction;
}
