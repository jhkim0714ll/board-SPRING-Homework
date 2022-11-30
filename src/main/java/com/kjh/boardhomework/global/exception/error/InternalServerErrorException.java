package com.kjh.boardhomework.global.exception.error;

import com.kjh.boardhomework.global.exception.CustomException;

public class InternalServerErrorException extends CustomException {

    private InternalServerErrorException() {
        super(GlobalErrorCode.INTERNAL_SERVER_ERROR);
    }

    public static final CustomException EXCEPTION = new InternalServerErrorException();
}
