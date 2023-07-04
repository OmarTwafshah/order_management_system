package com.orderManagement.example.repository;

import com.orderManagement.example.models.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface customerRepository extends JpaRepository<customer,Integer> {
    customer findByCustomerId(Integer id);
}
