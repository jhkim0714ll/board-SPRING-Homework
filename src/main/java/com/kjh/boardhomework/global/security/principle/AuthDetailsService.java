package com.kjh.boardhomework.global.security.principle;

import com.kjh.boardhomework.domain.user.entity.UserEntity;
import com.kjh.boardhomework.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) {
        UserEntity user = userRepository.findById(name)
                .orElseThrow(() -> new UsernameNotFoundException("유저가 없음"));
        return new AuthDetails(user);
    }
}
