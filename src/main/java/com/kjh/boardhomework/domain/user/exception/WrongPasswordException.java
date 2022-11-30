package com.kjh.boardhomework.domain.user.exception;

import com.kjh.boardhomework.domain.user.presentation.exception.UserErrorCode;
import com.kjh.boardhomework.global.exception.CustomException;
import org.springframework.http.HttpStatus;

public class WrongPasswordException extends CustomException {
    private WrongPasswordException() {
        super(UserErrorCode.WRONG_PASSWORD);
    }

    public static final CustomException EXCEPTION = new WrongPasswordException();
}
