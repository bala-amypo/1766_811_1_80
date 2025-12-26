/*package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BranchProfile {

    @Id
    @GeneratedValue
    private Long id;

    private String branchCode;
    private String branchName;
    private String contactEmail;
    private LocalDateTime lastSyncAt;
    private Boolean active;

    public BranchProfile() {}

    public BranchProfile(Long id, String branchCode, String branchName,
                         String contactEmail, LocalDateTime lastSyncAt, Boolean active) {
        this.id = id;
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.contactEmail = contactEmail;
        this.lastSyncAt = lastSyncAt;
        this.active = active;
    }

    @PrePersist
    public void prePersist() {
        if (lastSyncAt == null) lastSyncAt = LocalDateTime.now();
        if (active == null) active = true;
    }

    public Long getId() { return id; }
    public String getBranchCode() { return branchCode; }
    public Boolean getActive() { return active; }

    public void setId(Long id) { this.id = id; }
    public void setActive(Boolean active) { this.active = active; }
}
*/
