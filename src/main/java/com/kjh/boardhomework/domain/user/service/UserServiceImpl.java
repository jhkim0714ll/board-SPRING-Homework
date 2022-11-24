package com.kjh.boardhomework.domain.user.service;

import com.kjh.boardhomework.domain.token.service.TokenService;
import com.kjh.boardhomework.domain.user.entity.UserEntity;
import com.kjh.boardhomework.domain.user.exception.UserIdIsAlreadyException;
import com.kjh.boardhomework.domain.user.exception.UserNotFoundException;
import com.kjh.boardhomework.domain.user.exception.WrongPasswordException;
import com.kjh.boardhomework.domain.user.presentation.dto.request.JoinRequest;
import com.kjh.boardhomework.domain.user.presentation.dto.request.LoginRequest;
import com.kjh.boardhomework.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final TokenService tokenService;


    @Override
    public String login(LoginRequest loginRequest) {
        if(!userRepository.existsById(loginRequest.getId())) {
            throw UserNotFoundException.EXCEPTION;
        }

        UserEntity user = userRepository.findByIdAndPassword(loginRequest.getId(), loginRequest.getPassword())
                .orElseThrow(() -> WrongPasswordException.EXCEPTION);
        return tokenService.generateToken(user.getId());
    }

    @Override
    public void register(JoinRequest joinRequest) {
        if(userRepository.existsById(joinRequest.getId())) {
            throw UserIdIsAlreadyException.EXCEPTION;
        }

        UserEntity user = UserEntity.builder()
                .id(joinRequest.getId())
                .name(joinRequest.getName())
                .password(joinRequest.getPassword()).build();
        userRepository.save(user);
    }
}
