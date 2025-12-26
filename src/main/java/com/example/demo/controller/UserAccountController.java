package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.impl.UserAccountServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountServiceImpl userAccountService;

    public UserAccountController(UserAccountServiceImpl userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserAccount> registerUser(@RequestBody UserAccount user) {
        UserAccount created = userAccountService.register(user);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getUserById(@PathVariable Long id) {
        UserAccount user = userAccountService.getUser(id);
        if (user == null) {
            throw new ResourceNotFoundException("User not found with ID: " + id);
        }
        return ResponseEntity.ok(user);
    }
}
