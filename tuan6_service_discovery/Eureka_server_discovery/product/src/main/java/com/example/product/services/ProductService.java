package com.example.product.services;

import com.example.product.models.Product;
import com.example.product.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Product getProductById(long id){
        Product product = productRepository.findById(id).get();
        return product;
    }
}
