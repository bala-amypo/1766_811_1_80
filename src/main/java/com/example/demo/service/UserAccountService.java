// UserAccountService.java
package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {
    UserAccount create(UserAccount userAccount);
    UserAccount update(Long id, UserAccount userAccount);
    UserAccount getById(Long id);
    List<UserAccount> getAll();
    void delete(Long id);
}
