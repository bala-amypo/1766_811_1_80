// UserAccountServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository repository;

    @Override
    public UserAccount create(UserAccount userAccount) { return repository.save(userAccount); }

    @Override
    public UserAccount update(Long id, UserAccount userAccount) {
        userAccount.setId(id);
        return repository.save(userAccount);
    }

    @Override
    public UserAccount getById(Long id) { return repository.findById(id).orElse(null); }

    @Override
    public List<UserAccount> getAll() { return repository.findAll(); }

    @Override
    public void delete(Long id) { repository.deleteById(id); }
}
