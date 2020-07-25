package com.asegnz.product.controller;

import com.asegnz.product.model.Product;
import com.asegnz.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public Long newProduct(@RequestBody Product product) {
        return productService.store(product);
    }

    @GetMapping("/products")
    public List<Product> all() {
        return productService.recoverAll();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id) { return productService.recover(id);}
}
