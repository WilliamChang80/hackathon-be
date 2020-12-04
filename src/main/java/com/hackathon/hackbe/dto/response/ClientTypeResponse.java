package com.hackathon.hackbe.dto.response;

import com.hackathon.hackbe.entity.ClientType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class ClientTypeResponse {
    public List<ClientType> types;
}
