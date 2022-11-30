package com.kjh.boardhomework.global.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    public String generateAccessToken(String id) {
        long exp = 1000 * 60 * 60 * 24 * 7;
        return generateToken(id, exp);
    }

    private String generateToken(String id, Long exp) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "board")
                .setSubject(id)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }
}
