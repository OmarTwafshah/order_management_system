package com.orderManagement.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import bzu.order_management.Entity.Product_orderIdClass;
import javax.persistence.*;

@Entity(name = "product_order")
@Table(name = "product_order")
@Data
@IdClass(value = Product_orderIdClass.class)
public class product_order {
    @Id
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private product productId;

    @Id
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private order orderId;


    @Column(
            name = "product_order_quantity",
            nullable = false
    )
    private Integer productOrderQuantity;

    @Column(
            name = "product_order_price",
            nullable = false
    )
    private Double productOrderPrice;

    @Column(
            name = "product_order_vat",
            nullable = false
    )
    private Double productOrderVat;

}