/*package com.example.demo.controller;

import com.example.demo.entity.BranchProfile;
import com.example.demo.service.BranchProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
@Tag(name = "Branch Profiles")
public class BranchProfileController {

    private final BranchProfileService service;

    public BranchProfileController(BranchProfileService service) {
        this.service = service;
    }

    // POST /api/branches
    @PostMapping
    public BranchProfile create(@RequestBody BranchProfile profile) {
        return service.save(profile);
    }

    // PUT /api/branches/{id}/status
    @PutMapping("/{id}/status")
    public BranchProfile updateStatus(@PathVariable Long id) {
        return service.deactivate(id); // toggle/deactivate per service logic
    }

    // GET /api/branches/{id}
    @GetMapping("/{id}")
    public BranchProfile getById(@PathVariable Long id) {
        return service.findAll()
                .stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    // GET /api/branches
    @GetMapping
    public List<BranchProfile> getAll() {
        return service.findAll();
    }

    // GET /api/branches/lookup/{branchCode}
    @GetMapping("/lookup/{branchCode}")
    public BranchProfile lookup(@PathVariable String branchCode) {
        return service.findAll()
                .stream()
                .filter(b -> branchCode.equals(b.getBranchCode()))
                .findFirst()
                .orElseThrow();
    }
}
*/
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BranchProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public void setId(Long id) { this.id = id; }

    public String getBranchCode() { return branchCode; }
    public void setBranchCode(String branchCode) { this.branchCode = branchCode; }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public LocalDateTime getLastSyncAt() { return lastSyncAt; }
    public void setLastSyncAt(LocalDateTime lastSyncAt) { this.lastSyncAt = lastSyncAt; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
