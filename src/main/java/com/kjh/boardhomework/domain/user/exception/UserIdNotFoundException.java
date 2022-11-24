package com.kjh.boardhomework.domain.user.exception;

import com.kjh.boardhomework.global.exception.CustomException;
import org.springframework.http.HttpStatus;

public class UserIdNotFoundException extends CustomException {

    private UserIdNotFoundException() {
        super(HttpStatus.NOT_FOUND, "등록되지 않은 아이디입니다");
    }

    public static final CustomException EXCEPTION = new UserIdNotFoundException();
}
