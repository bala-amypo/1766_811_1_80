package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "branch_profiles")
public class BranchProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Branch code required")
    @Column(unique = true)
    private String branchCode;

    @NotBlank(message = "Branch name required")
    private String branchName;

    @Email(message = "Invalid email")
    private String contactEmail;

    @NotNull
    private Boolean active = true;

    @PastOrPresent
    private LocalDateTime lastSyncAt;

    @PrePersist
    void onCreate() {
        lastSyncAt = LocalDateTime.now();
    }

    public BranchProfile() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBranchCode() { return branchCode; }
    public void setBranchCode(String branchCode) { this.branchCode = branchCode; }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public LocalDateTime getLastSyncAt() { return lastSyncAt; }
}
