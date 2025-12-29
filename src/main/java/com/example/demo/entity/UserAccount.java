package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_accounts")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;  
    
   @Column(unique = true)
    private String email;
    
   @NotBlank
    @Size(min = 8) 
    private String password;
    
    private String role;
    
    private String department;
    
    private LocalDateTime createdAt;
    
    @PrePersist
    public void prePersist() {
        
        if (createdAt == null) createdAt = LocalDateTime.now();
        if (role == null) role = "REVIEWER";
    }
    
    public UserAccount() {}
    
    
    public UserAccount(Long id, String name, String email, String password, 
                       String role, String department, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.department = department;
        this.createdAt = createdAt;
    }
    
    
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    
    public String getUsername() { return email; }
    public void setUsername(String username) { this.email = username; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public boolean isEnabled() { return true; }
}


