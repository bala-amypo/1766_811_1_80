package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    private final String SECRET = "your-very-long-secret-key-that-must-be-at-least-32-characters";
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    
    public void initKey() { }

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateTokenForUser(UserAccount user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole());
        claims.put("userId", user.getId());
        claims.put("email", user.getEmail());
        return generateToken(claims, user.getEmail());
    }

    public String extractUsername(String token) {
        return parseToken(token).getPayload().getSubject();
    }

    
    public String extractRole(String token) {
        return parseToken(token).getPayload().get("role", String.class);
    }

    public Long extractUserId(String token) {
        return parseToken(token).getPayload().get("userId", Long.class);
    }

    
    public JwtResponseWrapper parseToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody(); 
        return new JwtResponseWrapper(claims);
    }

    public static class JwtResponseWrapper {
        private final Claims claims;
        public JwtResponseWrapper(Claims claims) { this.claims = claims; }
        public Claims getPayload() { return claims; }
    }

    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username);
    }
}