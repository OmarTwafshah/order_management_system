package com.orderManagement.example.controllers;

import com.orderManagement.example.Service.productService;
import com.orderManagement.example.dto.productDTO;
import com.orderManagement.example.models.product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class productController {
    private final productService service ;

    public productController(productService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<product> getProduct() {
        return service.getAllProduct();
    }

    @GetMapping("/get")
    public productDTO getProductById(@RequestParam(required = true) Integer id ) {
        return service.getProductById(id);
    }

    @DeleteMapping(path = "/delete")
    public Boolean deleteProduct(@RequestParam(required = true) Integer id) {
        return service.deleteProduct(id);
    }

    @PostMapping("/insert")
    public Boolean insertProduct(@RequestBody productDTO productDTO) {
        return service.createProduct(productDTO);
    }

    @PutMapping("/Update")
    public boolean updateProduct(@RequestParam(required = true) Integer id,@RequestBody productDTO productDTO) {
        return service.updateProduct(id,productDTO);
    }
}
