package com.orderManagement.example.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class customerDTO {
    private String customerFirstName;
    private String customerLastName;
    private String customerBornAt;

}
