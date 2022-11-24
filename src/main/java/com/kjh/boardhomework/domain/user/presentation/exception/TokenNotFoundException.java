package com.kjh.boardhomework.domain.user.presentation.exception;

import com.kjh.boardhomework.global.exception.CustomException;
import org.springframework.http.HttpStatus;

public class TokenNotFoundException extends CustomException {
    private TokenNotFoundException() {
        super(HttpStatus.BAD_REQUEST, "토큰이 없습니다");
    }

    public static final CustomException EXCEPTION = new TokenNotFoundException();
}
