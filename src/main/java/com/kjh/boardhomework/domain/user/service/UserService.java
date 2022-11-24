package com.kjh.boardhomework.domain.user.service;

import com.kjh.boardhomework.domain.user.presentation.dto.request.LoginRequest;
import com.kjh.boardhomework.domain.user.presentation.dto.response.LoginResponse;

public interface UserService {


     String login(LoginRequest loginRequest);
}
