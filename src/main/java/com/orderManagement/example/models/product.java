package com.orderManagement.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "product")
@Table(name = "product")
@Data
public class product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @Column(
            name = "product_id",
            updatable = false,
            nullable = false
    )
    private Integer productId;

    @Column(
            name = "product_slug",
            nullable = false
    )
    private String productSlug;

    @Column(
            name = "product_name",
            nullable = false
    )
    private String productName;

    @Column(
            name = "product_reference",
            nullable = false
    )
    private String productReference;

    @Column(
            name = "product_price",
            nullable = false
    )
    private Double productPrice;

    @Column(
            name = "product_vat",
            nullable = false
    )
    private Double productVat;

    @Column(
            name = "product_stockable",
            nullable = false
    )
    private Boolean productStockable;

    @JsonIgnore
    @OneToMany(mappedBy = "productId",cascade = CascadeType.ALL)
    private Set<stock> stocks;

    @JsonIgnore
    @OneToMany(mappedBy = "productId",cascade = CascadeType.ALL)
    private Set<product_order> product_orders;


}
