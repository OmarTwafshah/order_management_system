package com.orderManagement.example.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "stock")
@Table(name = "stock")
@Data
public class stock {
    @Id
    @SequenceGenerator(
            name = "stock_sequence",
            sequenceName = "stock_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stock_sequence"
    )
    @Column(
            name = "stock_id",
            updatable = false,
            nullable = false
    )
    private Integer stockId;

    @Column(
            name = "stock_quantity",
            nullable = false
    )
    private Integer stockQuantity;

    @Column(
            name = "stock_update_at",
            nullable = false
    )
    private LocalDateTime stockUpdateAt;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private product productId;

}
