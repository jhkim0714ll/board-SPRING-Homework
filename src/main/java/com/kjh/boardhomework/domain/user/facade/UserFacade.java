package com.kjh.boardhomework.domain.user.facade;

import com.kjh.boardhomework.domain.user.entity.UserEntity;
import com.kjh.boardhomework.domain.user.exception.UserNotFoundException;
import com.kjh.boardhomework.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public UserEntity getCurrentUser() {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByEmail(id);
    }

    private UserEntity getUserByEmail(String id) {
        return userRepository.findById(id)
                .orElseGet(UserEntity::new);
    }
}
