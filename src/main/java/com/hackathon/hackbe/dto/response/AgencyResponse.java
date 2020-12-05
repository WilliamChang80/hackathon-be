package com.hackathon.hackbe.dto.response;

import com.hackathon.hackbe.dto.entity.AgencyDto;
import com.hackathon.hackbe.entity.Agency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class AgencyResponse {
    List<AgencyDto> agencies;
}
