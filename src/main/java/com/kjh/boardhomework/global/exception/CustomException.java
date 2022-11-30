package com.kjh.boardhomework.global.exception;

import com.kjh.boardhomework.global.exception.error.ErrorProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public abstract class CustomException extends RuntimeException {
    private ErrorProperty errorProperty;
}
