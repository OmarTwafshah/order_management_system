package com.orderManagement.example.repository;

import com.orderManagement.example.models.product_order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface product_orderRepository extends JpaRepository<product_order,Integer> {
    product_order findByProductIdAndAndOrderId(Integer id1 , Integer id2);

    void deleteByProductIdAndOrderId(Integer id1 , Integer id2);

}
