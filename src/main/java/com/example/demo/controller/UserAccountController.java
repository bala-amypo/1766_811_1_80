package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class UserAccountController {

    private final UserAccountService service;
    private final JwtUtil jwtUtil;

    public UserAccountController(UserAccountService service,
                                 JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    // POST /auth/register
    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return service.register(user);
    }

    // POST /auth/login
    @PostMapping("/login")
    public String login(@RequestBody UserAccount user) {
        return jwtUtil.generateTokenForUser(user);
    }

    // GET /auth/users
    @GetMapping("/users")
    public List<UserAccount> users() {
        throw new UnsupportedOperationException("ADMIN only – fetch all users");
    }

    // GET /auth/users/{id}
    @GetMapping("/users/{id}")
    public UserAccount user(@PathVariable Long id) {
        throw new UnsupportedOperationException("ADMIN only – fetch user by ID");
    }
}
