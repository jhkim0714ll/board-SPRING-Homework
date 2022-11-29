package com.kjh.boardhomework.domain.user.exception;

import com.kjh.boardhomework.global.exception.CustomException;
import org.springframework.http.HttpStatus;

public class UserIdIsAlreadyException extends CustomException {

    private UserIdIsAlreadyException() {
        super(HttpStatus.NOT_FOUND, "이미 등록된 아이디입니다");
    }

    public static final CustomException EXCEPTION = new UserIdIsAlreadyException();
}
