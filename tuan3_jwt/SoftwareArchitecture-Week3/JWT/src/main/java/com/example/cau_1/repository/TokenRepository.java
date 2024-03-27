package com.example.cau_1.repository;

import com.example.cau_1.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository
        extends JpaRepository<Token, Long> {
    Token findByToken(String token);
}
