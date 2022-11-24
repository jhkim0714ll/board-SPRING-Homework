package com.kjh.boardhomework.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequest {

    private String id;
    private String password;
}
