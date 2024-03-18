package com.example.springboot_api_jwt_ad.repository;

import com.example.springboot_api_jwt_ad.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
