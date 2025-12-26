package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.List;
import java.util.Optional;

public interface UserAccountService {

    UserAccount registerUser(UserAccount userAccount);

    Optional<UserAccount> getUserByEmail(String email);

    Optional<UserAccount> getUserByUsername(String username);

    List<UserAccount> getAllUsers();

    UserAccount updateUser(Long id, UserAccount updatedUser);

    void deleteUser(Long id);
}
