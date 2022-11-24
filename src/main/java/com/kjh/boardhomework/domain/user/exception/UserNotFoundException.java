package com.kjh.boardhomework.domain.user.exception;

import com.kjh.boardhomework.global.exception.CustomException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends CustomException {

    private UserNotFoundException() {
        super(HttpStatus.NOT_FOUND, "존재하지 않은 유저 입니다");
    }

    public static final CustomException EXCEPTION = new UserNotFoundException();
}
