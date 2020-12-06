package com.hackathon.hackbe.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chat extends BaseEntity{

    @OneToOne
    Client client;

    @OneToOne
    Agency agency;

    @OneToOne
    User admin;

    @OneToMany
    List<Message> messages;

}
