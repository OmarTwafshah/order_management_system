package com.orderManagement.example.controllers;


import com.orderManagement.example.Service.product_orderService;
import com.orderManagement.example.dto.insertProduct_order;
import com.orderManagement.example.dto.product_orderDTO;
import com.orderManagement.example.dto.twoInteger;
import com.orderManagement.example.models.product_order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product_order")
@CrossOrigin
public class product_orderController {
    private final product_orderService service ;

    public product_orderController(product_orderService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<product_order> getproduct_orders() {
        return service.getAllProduct_order();
    }

    @GetMapping("/get")
    public product_orderDTO getproduct_orderById(@RequestParam(required = true) twoInteger id ) {
        return service.getProduct_orderById(id.getId1(),id.getId2());
    }

    @DeleteMapping(path = "/delete")
    public Boolean deleteProduct_order(@RequestParam(required = true) twoInteger id) {
        return service.deleteProduct_order(id.getId1(),id.getId2());
    }

    @PostMapping("/insert")
    public Boolean insertProduct_order(@RequestBody product_orderDTO product_orderDTO) {
        return service.createProduct_order(product_orderDTO);
    }

    @PutMapping("/Update")
    public boolean updateProduct_order(@RequestBody insertProduct_order product_orderDTO) {
        return service.updateProduct_order(product_orderDTO.getTwoInteger().getId1(),
                product_orderDTO.getTwoInteger().getId2(),
                product_orderDTO.getProduct_order());
    }
}
