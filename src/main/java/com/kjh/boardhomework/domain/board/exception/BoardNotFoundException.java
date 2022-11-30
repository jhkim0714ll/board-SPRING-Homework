package com.kjh.boardhomework.domain.board.exception;

import com.kjh.boardhomework.global.exception.CustomException;
import org.springframework.http.HttpStatus;

public class BoardNotFoundException extends CustomException {
    private BoardNotFoundException() {
        super(BoardErrorCode.BOARD_NOT_FOUND);
    }

    public static final CustomException EXCEPTION = new BoardNotFoundException();
}
