package com.kjh.boardhomework.domain.user.presentation.dto.response;

import com.kjh.boardhomework.domain.user.entity.UserEntity;
import lombok.Getter;

@Getter
public class UserResponse {

    private final String id;
    private final String name;

    public UserResponse(UserEntity user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
