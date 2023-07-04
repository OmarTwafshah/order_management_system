package com.orderManagement.example.controllers;

import com.orderManagement.example.Service.orderService;
import com.orderManagement.example.dto.insertProduct_order;
import com.orderManagement.example.dto.orderDTO;
import com.orderManagement.example.models.order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class orderController {
    private final orderService service ;

    public orderController(orderService service) {
        this.service = service;
    }


    @GetMapping("/getAll")
    public List<order> getOrder() {
        return service.getAllOrder();
    }

    @GetMapping("/get")
    public orderDTO getOrderById(@RequestParam(required = true) Integer id ) {
        return service.getOrderById(id);
    }

    @DeleteMapping(path = "/delete")
    public Boolean deleteOrder(@RequestParam(required = true) Integer id) {
        return service.deleteOrder(id);
    }

    @PostMapping("/insert")
    public Boolean insertOrder(@RequestBody orderDTO orderDTO) {
        return service.createOrder(orderDTO);
    }

    @PutMapping("/Update")
    public boolean updateOrder(@RequestParam(required = true) Integer id,@RequestBody orderDTO orderDTO) {
        return service.updateOrder(id,orderDTO);
    }
}
