package com.kjh.boardhomework.global.exception.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum GlobalErrorCode implements ErrorProperty {

    INTERNAL_SERVER_ERROR(500, "Server Error");

    private final int status;
    private final String message;
}