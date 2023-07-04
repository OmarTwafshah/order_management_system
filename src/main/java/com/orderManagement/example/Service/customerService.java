package com.orderManagement.example.Service;

import com.orderManagement.example.dto.customerDTO;
import com.orderManagement.example.models.customer;

import java.util.List;

public interface customerService {
    boolean createCustomer(customerDTO customerDTO);

    List<customer> getAllCustomer();

    customerDTO getCustomerById(Integer id);

    boolean updateCustomer(Integer id, customerDTO customerDTO);

    boolean deleteCustomer(Integer id);
}
