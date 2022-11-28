package com.kjh.boardhomework.global.interceptor;

import com.kjh.boardhomework.domain.token.service.TokenService;
import com.kjh.boardhomework.domain.user.entity.UserEntity;
import com.kjh.boardhomework.global.Extractor.AuthorizationExtractor;
import com.kjh.boardhomework.global.annotation.AuthorizationCheck;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@AllArgsConstructor
public class BearerAuthInterceptor implements HandlerInterceptor {
    private AuthorizationExtractor authExtractor;
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) {

        if(!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        AuthorizationCheck userLoginToken = handlerMethod.getMethodAnnotation(AuthorizationCheck.class);

        if (userLoginToken == null) {
            return true;
        }

        String token = authExtractor.extract(request);
        if (token == null || token.length() == 0) {
            return true;
        }

        if (tokenService.verifyToken(token) == null) {
            throw new IllegalArgumentException("유효하지 않은 토큰");
        }

        UserEntity user= tokenService.verifyToken(token);
        request.setAttribute("user", user);
        return true;
    }
}