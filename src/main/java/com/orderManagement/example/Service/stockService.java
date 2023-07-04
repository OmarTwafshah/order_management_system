package com.orderManagement.example.Service;


import com.orderManagement.example.dto.stockDTO;
import com.orderManagement.example.models.stock;

import java.util.List;

public interface stockService {
    boolean createStock(stockDTO stockDTO);

    List<stock> getAllStock();

    stockDTO getStockById(Integer id);

    boolean updateStock(Integer id, stockDTO stockDTO);

    boolean deleteStock(Integer id);
}
