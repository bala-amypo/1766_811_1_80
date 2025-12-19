package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    public UserAccount save(UserAccount user) {
        return repository.save(user);
    }

    public List<UserAccount> getAll() {
        return repository.findAll();
    }

    public UserAccount getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
