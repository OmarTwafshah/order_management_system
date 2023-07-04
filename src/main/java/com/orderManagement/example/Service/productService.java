package com.orderManagement.example.Service;


import com.orderManagement.example.dto.productDTO;
import com.orderManagement.example.models.product;

import java.util.List;

public interface productService {
    boolean createProduct(productDTO productDTO);

    List<product> getAllProduct();

    productDTO getProductById(Integer id);

    boolean updateProduct(Integer id, productDTO productDTO);

    boolean deleteProduct(Integer id);

}
