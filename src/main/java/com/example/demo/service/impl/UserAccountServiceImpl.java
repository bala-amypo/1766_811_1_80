package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserAccountServiceImpl(UserAccountRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    // Register new user
    @Override
    public UserAccount registerUser(UserAccount userAccount) {
        // Encode password before saving
        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        return repository.save(userAccount);
    }

    // Find user by email
    @Override
    public Optional<UserAccount> getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    // Find user by username
    @Override
    public Optional<UserAccount> getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    // Get all users
    @Override
    public List<UserAccount> getAllUsers() {
        return repository.findAll();
    }

    // Update user (example: update role or email)
    @Override
    public UserAccount updateUser(Long id, UserAccount updatedUser) {
        UserAccount existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (updatedUser.getEmail() != null) existing.setEmail(updatedUser.getEmail());
        if (updatedUser.getRole() != null) existing.setRole(updatedUser.getRole());
        if (updatedUser.getPassword() != null)
            existing.setPassword(passwordEncoder.encode(updatedUser.getPassword()));

        return repository.save(existing);
    }

    // Delete user
    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
