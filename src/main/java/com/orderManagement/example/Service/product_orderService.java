package com.orderManagement.example.Service;


import com.orderManagement.example.dto.product_orderDTO;
import com.orderManagement.example.models.product_order;

import java.util.List;

public interface product_orderService {
    boolean createProduct_order(product_orderDTO product_orderDTO);

    List<product_order> getAllProduct_order();

    product_orderDTO getProduct_orderById(Integer id1,Integer id2);

    boolean updateProduct_order(Integer id1, Integer id2, product_orderDTO product_orderDTO);

    boolean deleteProduct_order(Integer id1, Integer id2);
}
