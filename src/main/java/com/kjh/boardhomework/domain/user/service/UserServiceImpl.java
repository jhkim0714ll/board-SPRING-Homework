package com.kjh.boardhomework.domain.user.service;

import com.kjh.boardhomework.domain.user.entity.UserEntity;
import com.kjh.boardhomework.domain.user.presentation.dto.request.RegisterRequest;
import com.kjh.boardhomework.domain.user.presentation.dto.request.LoginRequest;
import com.kjh.boardhomework.domain.user.repository.UserRepository;
import com.kjh.boardhomework.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;


    @Override
    public String login(LoginRequest loginRequest) {
        if(!userRepository.existsById(loginRequest.getId())) {
            return "IdNotFound";
        }

        String password = passwordEncoder.encode(loginRequest.getPassword());
        UserEntity user = userRepository.findByIdAndPassword(loginRequest.getId(), password);
        if(user == null) {
            return "wrongPassword";
        }
        return jwtTokenProvider.generateAccessToken(user.getId());
    }

    @Override
    public String register(RegisterRequest registerRequest) {
        if(userRepository.existsById(registerRequest.getId())) {
            return "alreadyExistsId";
        }

        String password = passwordEncoder.encode(registerRequest.getPassword());
        UserEntity user = UserEntity.builder()
                .id(registerRequest.getId())
                .name(registerRequest.getName())
                .password(password).build();
        userRepository.save(user);
        return "";
    }
}
