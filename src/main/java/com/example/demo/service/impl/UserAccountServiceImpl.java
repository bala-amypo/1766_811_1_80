package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public UserAccount register(UserAccount user) {
        // t11: Duplicate check
        if (userAccountRepository.existsByEmail(user.getEmail())) {
            throw new ValidationException("Email already in use");
        }
        
        // t73: Password length check
        if (user.getPassword() == null || user.getPassword().length() < 8) {
            throw new ValidationException("Password must be at least 8 characters");
        }

        // t74: Default role
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("REVIEWER");
        }

        return userAccountRepository.save(user);
    }

    @Override
    public UserAccount getUser(Long id) {
        // t13: Required exception for missing user
        return userAccountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }
    
    // Additional methods for findByEmail and getAllUsers...
}

        // Fix for t74: Default Role Assignment
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("REVIEWER");
        }

        return userAccountRepository.save(user);
    }

    @Override
    public UserAccount findByEmail(String email) {
        // Handles Optional return from repository
        return userAccountRepository.findByEmail(email).orElse(null);
    }

    @Override
    public UserAccount getUser(Long id) {
        // Fix for t13: User Not Found Handling
        return userAccountRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userAccountRepository.findAll();
    }
}