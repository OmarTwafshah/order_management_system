package com.orderManagement.example.Service;

import com.orderManagement.example.dto.productDTO;
import com.orderManagement.example.models.product;
import com.orderManagement.example.repository.productRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productServiceImp implements productService{
    private final productRepository repository ;

    public productServiceImp(productRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean createProduct(productDTO productDTO) {
        product product1 = new product();
        product1.setProductSlug(productDTO.getProductSlug());
        product1.setProductName(productDTO.getProductName());
        product1.setProductReference(productDTO.getProductReference());
        product1.setProductPrice(productDTO.getProductPrice());
        product1.setProductVat(productDTO.getProductVat());
        product1.setProductStockable(productDTO.getProductStockable());
        repository.save(product1);
        return true;
    }

    @Override
    public List<product> getAllProduct() {
        return repository.findAll();
    }

    @Override
    public productDTO getProductById(Integer id) {
        product product = repository.findByProductId(id);
        productDTO product1 = new productDTO();
        product1.setProductSlug(product.getProductSlug());
        product1.setProductName(product.getProductName());
        product1.setProductReference(product.getProductReference());
        product1.setProductPrice(product.getProductPrice());
        product1.setProductVat(product.getProductVat());
        product1.setProductStockable(product.getProductStockable());
        return product1;
    }

    @Override
    public boolean updateProduct(Integer id, productDTO productDTO) {
        product product = repository.findById(id).orElse(null);
        product.setProductSlug(productDTO.getProductSlug());
        product.setProductName(productDTO.getProductName());
        product.setProductReference(productDTO.getProductReference());
        product.setProductPrice(productDTO.getProductPrice());
        product.setProductVat(productDTO.getProductVat());
        product.setProductStockable(productDTO.getProductStockable());
        repository.save(product);
        return true;
    }

    @Override
    public boolean deleteProduct(Integer id) {
        Boolean exist = repository.existsById(id);
        if (!exist) {
            System.out.println("product does not exist");
            return false;
        } else {
            repository.deleteById(id);
            return true;
        }
    }
}
