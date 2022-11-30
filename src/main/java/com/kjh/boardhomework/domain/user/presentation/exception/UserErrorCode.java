package com.kjh.boardhomework.domain.user.presentation.exception;

import com.kjh.boardhomework.global.exception.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum UserErrorCode implements ErrorProperty {

    USER_NOT_FOUND(404, "User Not Found"),
    TOKEN_EXPIRED(401, "Token Expired"),
    TOKEN_NOT_FOUND(404, "Token Not Found"),
    TOKEN_SERVER_EXCEPTION(500, "Server Error"),
    WRONG_PASSWORD(400, "Wrong Password"),
    USER_ID_ALREADY_EXIST(400, "User Id is Already Exist");

    private final int status;
    private final String message;
}
