package com.example.tuan_1_may2.controllers;

import com.example.tuan_1_may2.Repositories.UserRepository;
import com.example.tuan_1_may2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/users")
    List<User> getUsers(){
        return userRepository.findAll();
    }
}
