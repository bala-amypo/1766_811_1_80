package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;

import java.util.Collections;

public class CustomUserDetailsService implements UserDetailsService {

    private final UserAccountService service;

    public CustomUserDetailsService(UserAccountService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserAccount user = service.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new User(
                user.getEmail(),
                user.getPassword(),
                Collections.singleton(
                        new SimpleGrantedAuthority("ROLE_" + user.getRole())
                )
        );
    }
}
