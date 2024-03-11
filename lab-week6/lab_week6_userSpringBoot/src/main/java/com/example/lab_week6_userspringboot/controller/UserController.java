package com.example.lab_week6_userspringboot.controller;

import com.example.lab_week6_userspringboot.models.User;
import com.example.lab_week6_userspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAll(){
        List<User> list = userRepository.findAll();
        return list;
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable("id") long id){
        Optional<User> user =   userRepository.findById(id);
        return user;
    }

}
