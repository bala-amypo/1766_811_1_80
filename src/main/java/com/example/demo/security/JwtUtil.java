package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${jwt.secret:defaultSecretKeyWorkaroundAtLeast32Chars}")
    private String secret = "defaultSecretKeyWorkaroundAtLeast32Chars";

    private SecretKey key;

    @PostConstruct
    public void initKey() {
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    // Updated for t69, t70, t71: Must include email, role, and userId claims
    public String generateTokenForUser(UserAccount user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", user.getEmail());   // Required for t69
        claims.put("role", user.getRole());     // Required for t70
        claims.put("userId", user.getId());     // Required for t71
        
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Required for t69-t72: parseToken method returning Jws<Claims>
    // Update this in your JwtUtil.java
    public Jws<Claims> parseToken(String token) {
        return Jwts.parser() // Modern 0.12.x syntax
            .verifyWith(key) // Replaces setSigningKey
            .build()
            .parseSignedClaims(token); // Replaces parseClaimsJws
}
}