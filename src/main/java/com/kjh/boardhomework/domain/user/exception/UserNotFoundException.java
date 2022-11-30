package com.kjh.boardhomework.domain.user.exception;

import com.kjh.boardhomework.domain.user.presentation.exception.UserErrorCode;
import com.kjh.boardhomework.global.exception.CustomException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends CustomException {

    private UserNotFoundException() {
        super(UserErrorCode.USER_NOT_FOUND);
    }

    public static final CustomException EXCEPTION = new UserNotFoundException();
}
