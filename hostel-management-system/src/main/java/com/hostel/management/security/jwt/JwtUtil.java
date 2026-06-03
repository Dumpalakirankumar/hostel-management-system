package com.hostel.management.security.jwt;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import io.jsonwebtoken.Claims;

@Component
public class JwtUtil {

    private static final String SECRET =
            "hostelmanagementsystemjwtsecretkey123456";

    private static final long EXPIRATION =
            1000 * 60 * 60 * 24;

    private static final Key KEY =
            new SecretKeySpec(
                    SECRET.getBytes(),
                    SignatureAlgorithm.HS256.getJcaName());

    public String generateToken(String username) {

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(
                        new Date(System.currentTimeMillis()
                                + EXPIRATION))
                .signWith(KEY)
                .compact();
    }
    public String extractUsername(String token) {

        Claims claims = Jwts.parser()
                .verifyWith((javax.crypto.SecretKey) KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    public boolean validateToken(String token,
                                 String username) {

        String extractedUsername =
                extractUsername(token);

        return extractedUsername.equals(username);
    }
}