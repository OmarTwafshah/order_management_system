package com.orderManagement.example.Service;


import com.orderManagement.example.dto.orderDTO;
import com.orderManagement.example.models.order;

import java.util.List;

public interface orderService {
    boolean createOrder(orderDTO orderDTO);

    List<order> getAllOrder();

    orderDTO getOrderById(Integer id);

    boolean updateOrder(Integer id, orderDTO orderDTO);

    boolean deleteOrder(Integer id);
}
