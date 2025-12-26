package com.example.demo.service.impl;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.UserAccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserAccountServiceImpl {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository,
                                  PasswordEncoder passwordEncoder) {
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Register a new user
    public UserAccount registerUser(RegisterRequest request) {
        // Check if email already exists
        Optional<UserAccount> existing = userAccountRepository.findByEmail(request.getEmail());
        if (existing.isPresent()) {
            throw new ValidationException("Email already exists");
        }

        // Optional: password minimum length check
        if (request.getPassword() == null || request.getPassword().length() < 6) {
            throw new ValidationException("Password must be at least 6 characters");
        }

        UserAccount user = new UserAccount();
        user.setUsername(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole() != null ? request.getRole() : "REVIEWER");
        user.setDepartment(request.getDepartment());
        user.setCreatedAt(LocalDateTime.now());

        return userAccountRepository.save(user);
    }

    // Get user by ID
    public UserAccount getUserById(Long id) {
        return userAccountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    // Get user by email
    public UserAccount getUserByEmail(String email) {
        return userAccountRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
