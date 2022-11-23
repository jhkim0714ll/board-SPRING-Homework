package com.kjh.boardhomework.domain.board.exception;

import com.kjh.boardhomework.global.exception.CustomException;
import org.springframework.http.HttpStatus;

public class InvalidPasswordException extends CustomException {
    private InvalidPasswordException() {
        super(HttpStatus.FORBIDDEN, "잘못된 비밀번호입니다.");
    }

    public static final CustomException EXCEPTION = new InvalidPasswordException();
}
