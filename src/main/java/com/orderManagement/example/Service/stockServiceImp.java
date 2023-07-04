package com.orderManagement.example.Service;

import com.orderManagement.example.dto.stockDTO;
import com.orderManagement.example.models.stock;
import com.orderManagement.example.repository.productRepository;
import com.orderManagement.example.repository.stockRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class stockServiceImp implements stockService {

    private final stockRepository repository ;

    private final productRepository repository2 ;


    public stockServiceImp(stockRepository repository, productRepository repository2) {
        this.repository = repository;
        this.repository2 = repository2;
    }

    @Override
    public boolean createStock(stockDTO stockDTO) {
        stock stock1 = new stock();
        stock1.setStockQuantity(stockDTO.getStockQuantity());
        stock1.setProductId(repository2.findByProductId(stockDTO.getProductId()));
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        stock1.setStockUpdateAt(LocalDateTime.from(LocalDate.parse(stockDTO.getStockUpdateAt(),df)));
        repository.save(stock1);
        return true;
    }

    @Override
    public List<stock> getAllStock() {
        return repository.findAll();
    }

    @Override
    public stockDTO getStockById(Integer id) {

        stock stock = repository.findByStockId(id);
        stockDTO stock1 = new stockDTO();
        stock1.setStockQuantity(stock.getStockQuantity());
        stock1.setProductId(stock.getProductId().getProductId());
        stock1.setStockUpdateAt(String.valueOf(stock.getStockUpdateAt()));
        return stock1;
    }

    @Override
    public boolean updateStock(Integer id, stockDTO stockDTO) {
        stock stock = repository.findById(id).orElse(null);
        stock.setStockQuantity(stockDTO.getStockQuantity());
        stock.setProductId(repository2.findByProductId(stockDTO.getProductId()));
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        stock.setStockUpdateAt(LocalDateTime.from(LocalDate.parse(stockDTO.getStockUpdateAt(),df)));
        repository.save(stock);
        return true;
    }

    @Override
    public boolean deleteStock(Integer id) {
        Boolean exist = repository.existsById(id);
        if (!exist) {
            System.out.println("stock does not exist");
            return false;
        } else {
            repository.deleteById(id);
            return true;
        }
    }
}
