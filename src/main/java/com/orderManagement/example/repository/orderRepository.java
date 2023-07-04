package com.orderManagement.example.repository;

import com.orderManagement.example.models.order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface orderRepository extends JpaRepository<order,Integer> {
    order findByOrderId(Integer id);

}
