package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserAccount;

public interface UserAccountService {
    UserAccount save(UserAccount user);
    List<UserAccount> getAll();
}
