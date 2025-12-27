// /*package com.example.demo.controller;

// import com.example.demo.dto.ApiResponse;
// import com.example.demo.dto.LoginRequest;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.entity.UserAccount;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserAccountService;
// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/auth")
// @Tag(name = "Authentication")
// public class AuthController {
    
//     private final UserAccountService userAccountService;
//     private final JwtUtil jwtUtil;
//     private final PasswordEncoder passwordEncoder;
    
//     public AuthController(UserAccountService userAccountService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
//         this.userAccountService = userAccountService;
//         this.jwtUtil = jwtUtil;
//         this.passwordEncoder = passwordEncoder;
//     }
    
//     @PostMapping("/register")
//     @Operation(summary = "Register new user")
//     public ResponseEntity<ApiResponse> register(@RequestBody RegisterRequest request) {
//         UserAccount user = new UserAccount();
//         user.setFullName(request.getName());
//         user.setEmail(request.getEmail());
//         user.setPassword(passwordEncoder.encode(request.getPassword()));
//         user.setRole(request.getRole());
//         user.setDepartment(request.getDepartment());
        
//         UserAccount created = userAccountService.register(user);
//         return ResponseEntity.ok(new ApiResponse(true, "User registered successfully", created));
//     }
    
//     @PostMapping("/login")
//     @Operation(summary = "User login")
//     public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest request) {
//         UserAccount user = userAccountService.findByEmail(request.getEmail());
        
//         if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
//             String token = jwtUtil.generateToken(user.getEmail());
//             return ResponseEntity.ok(new ApiResponse(true, "Login successful", token));
//         }
        
//         return ResponseEntity.badRequest().body(new ApiResponse(false, "Invalid credentials", null));
//     }
    
//     @GetMapping("/users")
//     @Operation(summary = "Get all users")
//     @PreAuthorize("hasRole('ADMIN')")
//     public ResponseEntity<List<UserAccount>> getAllUsers() {
//         return ResponseEntity.ok(userAccountService.getAllUsers());
//     }
    
//     @GetMapping("/users/{id}")
//     @Operation(summary = "Get user by ID")
//     @PreAuthorize("hasRole('ADMIN')")
//     public ResponseEntity<UserAccount> getUser(@PathVariable Long id) {
//         return ResponseEntity.ok(userAccountService.getUser(id));
//     }
// }
// */
// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.dto.ApiResponse;
// import com.example.demo.dto.LoginRequest;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.entity.UserAccount;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserAccountService;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {
    
//     private final UserAccountService userAccountService;
//     private final JwtUtil jwtUtil;
//     private final PasswordEncoder passwordEncoder;
    
//     public AuthController(UserAccountService userAccountService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
//         this.userAccountService = userAccountService;
//         this.jwtUtil = jwtUtil;
//         this.passwordEncoder = passwordEncoder;
//     }
    
//     @PostMapping("/register")
//     public ResponseEntity<ApiResponse> register(@RequestBody RegisterRequest request) {
//         UserAccount user = new UserAccount();
//         user.setFullName(request.getName());
//         user.setEmail(request.getEmail());
//         user.setPassword(passwordEncoder.encode(request.getPassword()));
//         user.setRole(request.getRole());
//         user.setDepartment(request.getDepartment());
        
//         UserAccount created = userAccountService.register(user);
//         return ResponseEntity.ok(new ApiResponse(true, "User registered successfully", created));
//     }
    
//     @PostMapping("/login")
//     public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest request) {
//         UserAccount user = userAccountService.findByEmail(request.getEmail());
        
//         if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
//             String token = jwtUtil.generateToken(user.getEmail());
//             return ResponseEntity.ok(new ApiResponse(true, "Login successful", token));
//         }
        
//         return ResponseEntity.badRequest().body(new ApiResponse(false, "Invalid credentials", null));
//     }
    
//     @GetMapping("/users")
//     @PreAuthorize("hasRole('ADMIN')")
//     public ResponseEntity<List<UserAccount>> getAllUsers() {
//         return ResponseEntity.ok(userAccountService.getAllUsers());
//     }
    
//     @GetMapping("/users/{id}")
//     @PreAuthorize("hasRole('ADMIN')")
//     public ResponseEntity<UserAccount> getUser(@PathVariable Long id) {
//         return ResponseEntity.ok(userAccountService.getUser(id));
//     }
// }

package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserAccountRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, UserAccountRepository userRepository, 
                          PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        UserAccount user = new UserAccount();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        user.setDepartment(request.getDepartment());
        
        userRepository.save(user);
        return ResponseEntity.ok(Map.of("message", "User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        UserAccount user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtUtil.generateTokenForUser(user);
        return ResponseEntity.ok(Map.of("token", token));
    }
}