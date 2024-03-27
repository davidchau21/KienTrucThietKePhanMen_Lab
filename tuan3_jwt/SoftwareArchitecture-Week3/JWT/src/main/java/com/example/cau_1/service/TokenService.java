package com.example.cau_1.service;

import com.example.cau_1.entity.Token;

public interface TokenService {
    Token createToken(Token token);

    Token findByToken(String token);
}
