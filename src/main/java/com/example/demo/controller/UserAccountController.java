/*package com.example.demo.controller;

import com.example.demo.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserAccountController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestParam String username,
            @RequestParam String password
    ) {

        // 1️⃣ authenticate user
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        // 2️⃣ load UserDetails
        UserDetails userDetails =
                userDetailsService.loadUserByUsername(username);

        // 3️⃣ generate token (✅ FIX HERE)
        String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(token);
    }
}
*/
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
