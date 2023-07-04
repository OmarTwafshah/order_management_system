package com.orderManagement.example.controllers;

import com.orderManagement.example.Service.customerService;
import com.orderManagement.example.dto.customerDTO;
import com.orderManagement.example.dto.orderDTO;
import com.orderManagement.example.models.customer;
import com.orderManagement.example.models.order;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customer")
@CrossOrigin
public class customerController {
    private final customerService service ;

    public customerController(customerService service) {
        this.service = service;
    }


    @GetMapping("/getAll")
    public List<customer> getCustomer() {
        return service.getAllCustomer();
    }

    @GetMapping("/get")
    public customerDTO getCustomerById(@RequestParam(required = true) Integer id ) {
        return service.getCustomerById(id);
    }

    @DeleteMapping(path = "/delete")
    public Boolean deleteCustomer(@RequestParam(required = true) Integer id) {
        return service.deleteCustomer(id);
    }

    @PostMapping("/insert")
    public Boolean insertCustomer(@RequestBody customerDTO customerDTO) {
        return service.createCustomer(customerDTO);
    }

    @PutMapping("/Update")
    public boolean updateCustomer(@RequestParam(required = true) Integer id,@RequestBody customerDTO customerDTO) {
        return service.updateCustomer(id,customerDTO);
    }
}
