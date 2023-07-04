package com.orderManagement.example.dto;

import com.orderManagement.example.models.product;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class stockDTO {
    private Integer stockQuantity;
    private String stockUpdateAt;
    private Integer productId;

}
