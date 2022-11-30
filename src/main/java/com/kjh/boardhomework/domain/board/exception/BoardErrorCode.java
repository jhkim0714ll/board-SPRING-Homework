package com.kjh.boardhomework.domain.board.exception;

import com.kjh.boardhomework.global.exception.error.ErrorProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum BoardErrorCode implements ErrorProperty {

    BOARD_NOT_FOUND(404, "User Not Found");

    private final int status;
    private final String message;
}
