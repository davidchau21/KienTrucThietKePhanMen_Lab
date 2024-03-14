package com.example.apigatewayspringboot.controller;

import com.example.apigatewayspringboot.service.APIGetawayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class APIGetawayController {
    @Autowired
    private APIGetawayService apiGetawayService;

    @GetMapping("/listUser")
    public List<Map<String, Object>> getAllUsers(){
        List<Map<String, Object>> userList = apiGetawayService.getAllUser();
        return userList;
    }

    @GetMapping("/listProduct")
    public List<Map<String, Object>> getAllProduct(){
        List<Map<String, Object>> productList = apiGetawayService.getAllProduct();
        return productList;
    }

    @GetMapping("/listOrder")
    public List<Map<String, Object>> getAllOrders(){
        List<Map<String, Object>> orderList = apiGetawayService.getAllOrder();
        return orderList;
    }
}
