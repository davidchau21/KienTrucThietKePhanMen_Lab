package com.example.springboot_api_jwt_ad.service;

import com.example.springboot_api_jwt_ad.authen.UserPrincipal;
import com.example.springboot_api_jwt_ad.entity.User;

public interface UserService {
    User createUser(User user);
    UserPrincipal findByUserName(String username);
}
