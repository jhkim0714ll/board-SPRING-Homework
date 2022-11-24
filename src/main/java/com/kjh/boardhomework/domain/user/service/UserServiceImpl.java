package com.kjh.boardhomework.domain.user.service;

import com.kjh.boardhomework.domain.user.presentation.dto.request.LoginRequest;
import com.kjh.boardhomework.domain.user.presentation.dto.response.LoginResponse;
import com.kjh.boardhomework.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;


    @Override
    public String login(LoginRequest loginRequest) {

        return null;
    }
}
