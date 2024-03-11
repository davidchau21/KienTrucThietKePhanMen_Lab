package com.example.lab_week6_productstringboot.controller;

import com.example.lab_week6_productstringboot.models.Product;
import com.example.lab_week6_productstringboot.repositories.ProductRepository;
import com.example.lab_week6_productstringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/products")
    public List<Product> getAll(){
        List<Product> list = productRepository.findAll();
        return list;
    }

    @GetMapping("/list")
    public List<Map<String, Object>> getAllUsers(){
        List<Map<String, Object>> userList = productService.getAllUser();
        return userList;
    }


}
