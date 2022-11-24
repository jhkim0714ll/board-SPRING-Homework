package com.kjh.boardhomework.domain.user.exception;

import com.kjh.boardhomework.global.exception.CustomException;
import org.springframework.http.HttpStatus;

public class WrongPasswordException extends CustomException {
    private WrongPasswordException() {
        super(HttpStatus.FORBIDDEN, "비밀번호가 틀렸습니다");
    }

    public static final CustomException EXCEPTION = new WrongPasswordException();
}
