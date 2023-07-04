package com.orderManagement.example.Service;

import com.orderManagement.example.dto.product_orderDTO;
import com.orderManagement.example.models.product_order;
import com.orderManagement.example.repository.orderRepository;
import com.orderManagement.example.repository.productRepository;
import com.orderManagement.example.repository.product_orderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class product_orderServiceImp implements product_orderService{
    private final product_orderRepository repository ;
    private final orderRepository repository2 ;
    private final productRepository repository3 ;


    public product_orderServiceImp(product_orderRepository repository, orderRepository repository2, productRepository repository3) {
        this.repository = repository;
        this.repository2 = repository2;
        this.repository3 = repository3;
    }

    @Override
    public boolean createProduct_order(product_orderDTO product_orderDTO) {
        product_order product_order = new product_order();
        product_order.setProductId(repository3.findByProductId(product_orderDTO.getProductId()));
        product_order.setOrderId(repository2.findByOrderId(product_orderDTO.getOrderId()));
        product_order.setProductOrderPrice(product_orderDTO.getProductOrderPrice());
        product_order.setProductOrderQuantity(product_orderDTO.getProductOrderQuantity());
        product_order.setProductOrderVat(product_orderDTO.getProductOrderVat());
        repository.save(product_order);
        return true;
    }

    @Override
    public List<product_order> getAllProduct_order() {
        return repository.findAll();
    }

    @Override
    public product_orderDTO getProduct_orderById(Integer id1,Integer id2) {
        product_order product_order = repository.findByProductIdAndAndOrderId(id1,id2);
        product_orderDTO product_order1 = new product_orderDTO();
        product_order1.setOrderId(product_order.getOrderId().getOrderId());
        product_order1.setProductId(product_order.getProductId().getProductId());
        product_order1.setProductOrderQuantity(product_order.getProductOrderQuantity());
        product_order1.setProductOrderPrice(product_order.getProductOrderPrice());
        product_order1.setProductOrderVat(product_order.getProductOrderVat());
        return product_order1;
    }

    @Override
    public boolean updateProduct_order(Integer id1, Integer id2, product_orderDTO product_orderDTO) {
        product_order product_order = repository.findByProductIdAndAndOrderId(id1,id2);
        product_order.setProductId(repository3.findByProductId(product_orderDTO.getProductId()));
        product_order.setOrderId(repository2.findByOrderId(product_orderDTO.getOrderId()));
        product_order.setProductOrderQuantity(product_orderDTO.getProductOrderQuantity());
        product_order.setProductOrderPrice(product_orderDTO.getProductOrderPrice());
        product_order.setProductOrderVat(product_orderDTO.getProductOrderVat());
        repository.save(product_order);
        return true;

    }

    @Override
    public boolean deleteProduct_order(Integer id1, Integer id2) {
        product_order exist = repository.findByProductIdAndAndOrderId(id1,id2);
        if (exist == null) {
            System.out.println("Product_order does not exist");
            return false;
        } else {
            repository.deleteByProductIdAndOrderId(id1,id2);
            return true;
        }
    }
}
