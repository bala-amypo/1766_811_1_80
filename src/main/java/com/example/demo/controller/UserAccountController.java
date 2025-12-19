package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping
    public UserAccount createUser(@Valid @RequestBody UserAccount user) {
        return userAccountService.save(user);
    }

    @GetMapping
    public List<UserAccount> getAllUsers() {
        return userAccountService.getAll();
    }
}
