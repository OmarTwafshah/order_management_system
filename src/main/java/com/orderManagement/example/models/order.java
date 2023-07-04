package com.orderManagement.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "order")
@Table(name = "order")
@Data
public class order {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    @Column(
            name = "order_id",
            updatable = false,
            nullable = false
    )
    private Integer orderId;

    @Column(
            name = "order_ordered_at",
            nullable = false
    )
    private LocalDateTime orderOrderedAt;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private customer newCustomer ;

    @JsonIgnore
    @OneToMany(mappedBy = "orderId",cascade = CascadeType.ALL)
    private Set<product_order> product_orders;

}
