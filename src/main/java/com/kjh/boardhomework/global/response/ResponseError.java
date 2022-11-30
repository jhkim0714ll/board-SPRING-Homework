package com.kjh.boardhomework.global.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseError extends Response {

    @Builder
    public ResponseError(int status, String message) {
        super(status, message);
    }
}
