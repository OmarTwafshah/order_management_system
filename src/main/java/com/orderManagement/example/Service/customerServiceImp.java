package com.orderManagement.example.Service;

import com.orderManagement.example.dto.customerDTO;
import com.orderManagement.example.models.customer;
import com.orderManagement.example.repository.customerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class customerServiceImp implements customerService{
    private final customerRepository repository ;

    public customerServiceImp(customerRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean createCustomer(customerDTO customerDto) {
        customer customer1 = new customer();
        customer1.setCustomerFirstName(customerDto.getCustomerFirstName());
        customer1.setCustomerLastName(customerDto.getCustomerLastName());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        customer1.setCustomerBornAt(LocalDateTime.from(LocalDate.parse(customerDto.getCustomerBornAt(),df)));
        repository.save(customer1);
        return true;
    }

    @Override
    public List<customer> getAllCustomer() {
        return repository.findAll();
    }

    @Override
    public customerDTO getCustomerById(Integer id) {

        customer customer = repository.findByCustomerId(id);
        customerDTO customer1 = new customerDTO();
        customer1.setCustomerFirstName(customer.getCustomerFirstName());
        customer1.setCustomerLastName(customer.getCustomerLastName());
        customer1.setCustomerBornAt(String.valueOf(customer.getCustomerBornAt()));
        return customer1;
    }

    @Override
    public boolean updateCustomer(Integer id, customerDTO customerDto) {
        customer customer = repository.findById(id).orElse(null);
        if (customer == null) {
            return false;
        }

        if (customerDto.getCustomerFirstName() != null) {
            customer.setCustomerFirstName(customerDto.getCustomerFirstName());
        }

        if (customerDto.getCustomerLastName() != null) {
            customer.setCustomerLastName(customerDto.getCustomerLastName());
        }

        if (customerDto.getCustomerBornAt() != null) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            customer.setCustomerBornAt(LocalDateTime.from(LocalDate.parse(customerDto.getCustomerBornAt(),df)));
        }

        return true;
    }

    @Override
    public boolean deleteCustomer(Integer id) {
        Boolean exist = repository.existsById(id);
        if (!exist) {
            System.out.println("customer does not exist");
            return false;
        } else {
            repository.deleteById(id);
            return true;
        }
    }
}
