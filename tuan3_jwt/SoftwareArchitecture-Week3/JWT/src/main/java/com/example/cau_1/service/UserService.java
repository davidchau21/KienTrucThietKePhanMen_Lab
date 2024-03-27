package com.example.cau_1.service;

import com.example.cau_1.authen.UserPrincipal;
import com.example.cau_1.entity.User;

public interface UserService {
    User createUser(User user);
    UserPrincipal findByUsername(String username);
}
