package com.orderManagement.example.dto;

import lombok.Data;

@Data
public class productDTO {
    private String productSlug;
    private String productName;
    private String productReference;
    private Double productPrice;
    private Double productVat;
    private Boolean productStockable;

}
