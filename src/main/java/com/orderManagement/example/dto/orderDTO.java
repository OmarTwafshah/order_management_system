package com.orderManagement.example.dto;

import com.orderManagement.example.models.customer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class orderDTO {
    private String orderOrderedAt;
    private Integer customerId ;

}
