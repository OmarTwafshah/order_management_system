package com.orderManagement.example.Service;

import com.orderManagement.example.dto.orderDTO;
import com.orderManagement.example.models.order;
import com.orderManagement.example.repository.customerRepository;
import com.orderManagement.example.repository.orderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class OrderServiceImp implements orderService{
    private final orderRepository repository ;

    private final customerRepository repository2 ;


    public OrderServiceImp(orderRepository repository, customerRepository repository2) {
        this.repository = repository;
        this.repository2 = repository2;
    }

    @Override
    public boolean createOrder(orderDTO orderDTO) {
        order order1 = new order();
        order1.setNewCustomer(repository2.findByCustomerId(orderDTO.getCustomerId()));
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        order1.setOrderOrderedAt(LocalDateTime.from(LocalDate.parse(orderDTO.getOrderOrderedAt(),df)));
        repository.save(order1);
        return true;
    }

    @Override
    public List<order> getAllOrder() {
        return repository.findAll();

    }

    @Override
    public orderDTO getOrderById(Integer id) {
        order order = repository.findByOrderId(id);
        orderDTO order1 = new orderDTO();
        order1.setCustomerId(order.getNewCustomer().getCustomerId());
        order1.setOrderOrderedAt(String.valueOf(order.getOrderOrderedAt()));
        return order1;
    }

    @Override
    public boolean updateOrder(Integer id, orderDTO orderDTO) {
        order order = repository.findById(id).orElse(null);
        if (order == null) {
            return false;
        }

        if (orderDTO.getCustomerId() != null) {
            order.setNewCustomer(repository2.findByCustomerId(orderDTO.getCustomerId()));
        }

        if (orderDTO.getOrderOrderedAt() != null) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            order.setOrderOrderedAt(LocalDateTime.from(LocalDate.parse(orderDTO.getOrderOrderedAt(),df)));
        }

        return true;
    }

    @Override
    public boolean deleteOrder(Integer id) {
        Boolean exist = repository.existsById(id);
        if (!exist) {
            System.out.println("order does not exist");
            return false;
        } else {
            repository.deleteById(id);
            return true;
        }
    }
}
