package com.hackathon.hackbe.dto.entity;

import com.hackathon.hackbe.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDetailDto {
    private Long serviceId;
    private String serviceName;

    private Integer quantity;

    private Integer price;

    private String term;

    private Date deadline;
}
