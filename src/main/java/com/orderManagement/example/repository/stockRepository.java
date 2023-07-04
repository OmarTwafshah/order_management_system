package com.orderManagement.example.repository;

import com.orderManagement.example.models.stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface stockRepository extends JpaRepository<stock,Integer> {
    stock findByStockId(Integer id);

}
