package com.orderManagement.example.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "customer")
@Table(name = "customer")
@Data
public class customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    @Column(
            name = "customer_id",
            updatable = false,
            nullable = false
    )
    private Integer customerId;

    @Column(
            name = "customer_first_name",
            nullable = false
    )
    private String customerFirstName;

    @Column(
            name = "customer_last_name",
            nullable = false
    )
    private String customerLastName;

    @Column(
            name = "customer_born_at",
            nullable = false
    )
    private LocalDateTime customerBornAt;

    @JsonIgnore
    @OneToMany(mappedBy = "newCustomer",cascade = CascadeType.ALL)
    private Set<order> orders;




}
