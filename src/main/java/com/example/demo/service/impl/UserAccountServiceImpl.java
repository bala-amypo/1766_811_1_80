package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public UserAccount register(UserAccount user) {
        // Fix for t73: Must throw ValidationException with this exact message
        if (user.getPassword() == null || user.getPassword().length() < 8) {
            throw new ValidationException("Password must be at least 8 characters");
        }
        return userAccountRepository.save(user);
    }

    @Override
    public UserAccount findByEmail(String email) {
        return userAccountRepository.findByEmail(email).orElse(null);
    }

    @Override
    public UserAccount getUser(Long id) {
        return userAccountRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userAccountRepository.findAll();
    }
}