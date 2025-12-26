package com.example.demo.service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;

public interface UserAccountService {
    UserAccount registerUser(RegisterRequest request);
    UserAccount getUserById(Long id);
    UserAccount getUserByEmail(String email);
}
