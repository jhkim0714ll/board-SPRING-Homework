package com.kjh.boardhomework.domain.user.service;

import com.kjh.boardhomework.domain.user.presentation.dto.request.RegisterRequest;
import com.kjh.boardhomework.domain.user.presentation.dto.request.LoginRequest;

public interface UserService {


     String login(LoginRequest loginRequest);

     void register(RegisterRequest registerRequest);
}
