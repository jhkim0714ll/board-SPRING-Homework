package com.kjh.boardhomework.domain.user.presentation.exception;

import com.kjh.boardhomework.global.exception.CustomException;
import org.springframework.http.HttpStatus;

public class TokenExpiredException extends CustomException {
    private TokenExpiredException() {
        super(HttpStatus.GONE, "토큰이 만료되었습니다");
    }

    public static final CustomException EXCEPTION = new TokenExpiredException();
}
