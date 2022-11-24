package com.kjh.boardhomework.domain.user.exception;

import com.kjh.boardhomework.global.exception.CustomException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends CustomException {

    private UserNotFoundException() {
        super(HttpStatus.NOT_FOUND, "아이디가 틀렸습니다");
    }

    public static final CustomException EXCEPTION = new UserNotFoundException();
}
