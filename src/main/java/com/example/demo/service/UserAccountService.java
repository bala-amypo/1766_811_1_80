package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.Optional;

public interface UserAccountService {

    UserAccount register(UserAccount userAccount);

    Optional<UserAccount> findByEmail(String email);
}
