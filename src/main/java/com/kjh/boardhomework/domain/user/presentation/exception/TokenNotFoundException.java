package com.kjh.boardhomework.domain.user.presentation.exception;

import com.kjh.boardhomework.global.exception.CustomException;

public class TokenNotFoundException extends CustomException {
    private TokenNotFoundException() {
        super(UserErrorCode.TOKEN_NOT_FOUND);
    }

    public static final CustomException EXCEPTION = new TokenNotFoundException();
}
