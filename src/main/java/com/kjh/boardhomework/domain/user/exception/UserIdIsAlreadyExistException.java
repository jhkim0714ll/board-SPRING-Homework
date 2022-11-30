package com.kjh.boardhomework.domain.user.exception;

import com.kjh.boardhomework.domain.user.presentation.exception.UserErrorCode;
import com.kjh.boardhomework.global.exception.CustomException;

public class UserIdIsAlreadyExistException extends CustomException {

    private UserIdIsAlreadyExistException() {
        super(UserErrorCode.USER_ID_ALREADY_EXIST);
    }

    public static final CustomException EXCEPTION = new UserIdIsAlreadyExistException();
}
