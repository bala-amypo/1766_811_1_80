package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.exception.ValidationException;
import com.example.demo.service.impl.UserAccountServiceImpl;
import com.example.demo.security.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountServiceImpl userAccountService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public UserAccountController(UserAccountServiceImpl userAccountService,
                                 AuthenticationManager authenticationManager,
                                 JwtUtil jwtUtil) {
        this.userAccountService = userAccountService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    // ---------------- Register ----------------
    @PostMapping("/register")
    public ResponseEntity<JwtResponse> registerUser(@Valid @RequestBody RegisterRequest request) {
        UserAccount user = new UserAccount(
                null,
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                request.getRole(),
                request.getDepartment(),
                null
        );

        try {
            UserAccount created = userAccountService.register(user);
            String token = jwtUtil.generateTokenForUser(created);
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (ValidationException ex) {
            return ResponseEntity.badRequest().body(new JwtResponse(ex.getMessage()));
        }
    }

    // ---------------- Login ----------------
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> loginUser(@Valid @RequestBody LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
            UserAccount user = userAccountService.getUserByEmail(request.getEmail());
            String token = jwtUtil.generateTokenForUser(user);
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(401).body(new JwtResponse("Invalid credentials"));
        }
    }

    // ---------------- Optional: Get current user ----------------
    @GetMapping("/me")
    public ResponseEntity<UserAccount> getCurrentUser(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7);
        String email = jwtUtil.extractUsername(token);
        UserAccount user = userAccountService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }
}
