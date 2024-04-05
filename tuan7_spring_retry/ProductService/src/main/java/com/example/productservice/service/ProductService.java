package com.example.productservice.service;

import com.example.productservice.model.Product;
import com.example.productservice.model.User;
import com.example.productservice.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class ProductService {
    private ProductRepository productRepository;
    private final RestTemplate restTemplate;

    public ProductService(ProductRepository productRepository, RestTemplate restTemplate) {
        this.productRepository = productRepository;
        this.restTemplate = restTemplate;
    }


    @Retry(name = "retryApi")
    public List<Product> getListProduct(){
        List<Product> productList = productRepository.findAll();
        for (Product o: productList) {
            User user = restTemplate.getForObject("http://localhost:8081/users/"+o.getId(), User.class);
            o.setUser(user);
        }
        return productList;
    }

    public Product getProductById(long id){
        Product product = productRepository.findById(id).get();
        User user = restTemplate.getForObject("http://localhost:8081/users/"+id, User.class);
        product.setUser(user);
        return product;
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProductById(long id){
        productRepository.deleteById(id);
    }
}
