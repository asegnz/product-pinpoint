package com.asegnz.product.service;

import com.asegnz.product.model.Product;
import com.asegnz.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Long store(Product product) {
        return repository.save(product).getId();
    }

    public List<Product> recoverAll() {
        return repository.findAll();
    }

    public Product recover(Long id) {
        return repository.findById(id).orElse(null);
    }
}
