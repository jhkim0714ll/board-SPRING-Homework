package com.kjh.boardhomework.domain.user.presentation.exception;

import com.kjh.boardhomework.global.exception.CustomException;
import org.springframework.http.HttpStatus;

public class TokenServerException extends CustomException {
    private TokenServerException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "토큰 해석 중 에러 발생했습니다");
    }

    public static final CustomException EXCEPTION = new TokenServerException();
}
