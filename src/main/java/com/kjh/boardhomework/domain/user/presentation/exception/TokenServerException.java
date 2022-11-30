package com.kjh.boardhomework.domain.user.presentation.exception;

import com.kjh.boardhomework.global.exception.CustomException;
import org.springframework.http.HttpStatus;

public class TokenServerException extends CustomException {
    private TokenServerException() {
        super(UserErrorCode.TOKEN_SERVER_EXCEPTION);
    }

    public static final CustomException EXCEPTION = new TokenServerException();
}
