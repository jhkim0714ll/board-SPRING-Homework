package com.kjh.boardhomework.global.security.jwt;

import com.kjh.boardhomework.domain.user.presentation.exception.TokenExpiredException;
import com.kjh.boardhomework.global.security.principle.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Component
public class JwtTokenParser {

    private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer ";
    private final AuthDetailsService authDetailsService;

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(HEADER);

        if (bearerToken != null && bearerToken.startsWith(PREFIX)) {
            return bearerToken.replace(PREFIX, "");
        }

        return null;
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = authDetailsService
                .loadUserByUsername(getTokenBody(token).getSubject());

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private Claims getTokenBody(String token) {
        try {
            return Jwts.parser().setSigningKey("board")
                    .parseClaimsJws(token).getBody();
        } catch (SignatureException e) {
            throw TokenExpiredException.EXCEPTION;
        }
    }
}
