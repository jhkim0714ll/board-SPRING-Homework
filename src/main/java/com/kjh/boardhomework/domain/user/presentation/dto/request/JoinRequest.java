package com.kjh.boardhomework.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JoinRequest {

    private String id;
    private String name;
    private String password;
}
