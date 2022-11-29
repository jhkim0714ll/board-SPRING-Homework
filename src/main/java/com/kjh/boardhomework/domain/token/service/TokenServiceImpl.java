package com.kjh.boardhomework.domain.token.service;

import com.kjh.boardhomework.domain.user.entity.UserEntity;
import com.kjh.boardhomework.domain.user.exception.UserNotFoundException;
import com.kjh.boardhomework.domain.user.presentation.exception.TokenExpiredException;
import com.kjh.boardhomework.domain.user.presentation.exception.TokenNotFoundException;
import com.kjh.boardhomework.domain.user.presentation.exception.TokenServerException;
import com.kjh.boardhomework.domain.user.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService{

    private final UserRepository userRepository;

    private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    private final long expire = 1000 * 60 * 60 * 24 * 7;


    @Override
    public String generateToken(String memberId) {
        Date expiredAt = new Date();

        Map<String, Object> claims = new HashMap<>();
        claims.put("user", memberId);

        expiredAt = new Date(expiredAt.getTime() + expire);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject("ACCESS")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expiredAt)
                .signWith(signatureAlgorithm, "Board")
                .compact();
    }

    @Override
    public UserEntity verifyToken(String token) {
        return userRepository.findById(parseToken(token).get("user").toString())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    private Claims parseToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey("Board")
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw TokenExpiredException.EXCEPTION;
        } catch (IllegalArgumentException e) {
            throw TokenNotFoundException.EXCEPTION;
        } catch (Exception e) {
            throw TokenServerException.EXCEPTION;
        }
    }
}
