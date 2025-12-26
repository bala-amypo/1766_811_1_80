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
package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/register")
    public UserAccount registerUser(@RequestBody RegisterRequest request) {
        UserAccount ua = new UserAccount();
        ua.setName(request.getName());
        ua.setEmail(request.getEmail());
        ua.setPassword(request.getPassword());
        ua.setRole(request.getRole());
        ua.setDepartment(request.getDepartment());
        return userAccountService.register(ua);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest request) {
        // Normally JWT generation and authentication happens here
        return "Login simulated for " + request.getEmail();
    }
}
