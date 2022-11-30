package com.kjh.boardhomework.domain.user.presentation.exception;

import com.kjh.boardhomework.global.exception.CustomException;

public class TokenExpiredException extends CustomException {
    private TokenExpiredException() {
        super(UserErrorCode.TOKEN_EXPIRED);
    }

    public static final CustomException EXCEPTION = new TokenExpiredException();
}
