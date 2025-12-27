/*package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;
import java.util.Optional;

public interface UserAccountService {
    UserAccount registerUser(UserAccount userAccount);
    Optional<UserAccount> getUserByEmail(String email);
    Optional<UserAccount> getUserByUsername(String username);
    List<UserAccount> getAllUsers();
}
*/
/*
package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.List;
import java.util.Optional;

public interface UserAccountService {

    UserAccount registerUser(UserAccount userAccount);

    Optional<UserAccount> login(String username, String password);

    Optional<UserAccount> getUserById(Long id);

    Optional<UserAccount> getUserByEmail(String email);

    Optional<UserAccount> getUserByUsername(String username);

    List<UserAccount> getAllUsers();
}
*/
package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {
    UserAccount register(UserAccount user);
    UserAccount findByEmail(String email);
    UserAccount getUser(Long id);
    List<UserAccount> getAllUsers();
}