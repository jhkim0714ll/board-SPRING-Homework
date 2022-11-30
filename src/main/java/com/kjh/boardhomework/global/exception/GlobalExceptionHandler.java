package com.kjh.boardhomework.global.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    protected String handleCustomException(UsernameNotFoundException e) {
        return "/user/login";
    }
}
