package com.orderManagement.example.controllers;

import com.orderManagement.example.Service.stockService;
import com.orderManagement.example.dto.stockDTO;
import com.orderManagement.example.models.stock;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
@CrossOrigin
public class stockController {
    private final stockService service ;

    public stockController(stockService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<stock> getStock() {
        return service.getAllStock();
    }

    @GetMapping("/get")
    public stockDTO getStockById(@RequestParam(required = true) Integer id ) {
        return service.getStockById(id);
    }

    @DeleteMapping(path = "/delete")
    public Boolean deleteStock(@RequestParam(required = true) Integer id) {
        return service.deleteStock(id);
    }

    @PostMapping("/insert")
    public Boolean insertStock(@RequestBody stockDTO stockDTO) {
        return service.createStock(stockDTO);
    }

    @PutMapping("/Update")
    public boolean updateStock(@RequestParam(required = true) Integer id,@RequestBody stockDTO stockDTO) {
        return service.updateStock(id,stockDTO);
    }
}
