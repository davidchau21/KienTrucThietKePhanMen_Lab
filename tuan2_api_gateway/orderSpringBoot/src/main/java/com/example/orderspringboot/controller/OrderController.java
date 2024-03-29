package com.example.orderspringboot.controller;

import com.example.orderspringboot.models.Order;
import com.example.orderspringboot.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders")
    public List<Order> getAll(){
        List<Order> list = orderRepository.findAll();
        return list;
    }
}
