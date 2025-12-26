package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserAccountServiceImpl(UserAccountRepository repository,
                                  PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserAccount register(UserAccount userAccount) {
        if (repository.existsByEmail(userAccount.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        userAccount = new UserAccount(
                null,
                userAccount.getEmail(),
                userAccount.getEmail(),
                passwordEncoder.encode(userAccount.getPassword()),
                userAccount.getRole(),
                null,
                true,
                null
        );

        return repository.save(userAccount);
    }

    @Override
    public Optional<UserAccount> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
