package com.kjh.boardhomework.domain.token.service;

import com.kjh.boardhomework.domain.user.entity.UserEntity;

public interface TokenService {

    String generateToken(String userId);

    UserEntity verifyToken(String token);
}
