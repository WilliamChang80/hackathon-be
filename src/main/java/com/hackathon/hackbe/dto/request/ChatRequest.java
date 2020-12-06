package com.hackathon.hackbe.dto.request;


import com.hackathon.hackbe.entity.Agency;
import com.hackathon.hackbe.entity.Client;
import com.hackathon.hackbe.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRequest {
    Client client;

    Agency agency;
}
