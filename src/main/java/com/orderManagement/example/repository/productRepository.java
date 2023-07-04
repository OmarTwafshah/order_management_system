package com.orderManagement.example.repository;

import com.orderManagement.example.models.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<product,Integer> {
    product findByProductId(Integer id);
}
