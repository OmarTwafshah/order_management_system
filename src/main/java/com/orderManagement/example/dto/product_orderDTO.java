package com.orderManagement.example.dto;

import com.orderManagement.example.models.order;
import com.orderManagement.example.models.product;
import lombok.Data;

@Data
public class product_orderDTO {
    private Integer productId;
    private Integer orderId;
    private Integer productOrderQuantity;
    private Double productOrderPrice;
    private Double productOrderVat;

}
