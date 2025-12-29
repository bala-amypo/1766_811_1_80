package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BranchProfile;
import com.example.demo.service.BranchProfileService;

@RestController
@RequestMapping("/api/branches")
public class BranchProfileController {

    private final BranchProfileService service;

    public BranchProfileController(BranchProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BranchProfile> create(
            @RequestBody BranchProfile branchProfile) {
        return ResponseEntity.ok(service.createBranch(branchProfile));
    }

    @PutMapping("/{id}/status/{active}")
    public ResponseEntity<BranchProfile> updateStatus(
            @PathVariable Long id,
            @PathVariable boolean active) {
        return ResponseEntity.ok(service.updateBranchStatus(id, active));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchProfile> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getBranchById(id));
    }

    @GetMapping
    public ResponseEntity<List<BranchProfile>> getAll() {
        return ResponseEntity.ok(service.getAllBranches());
    }

    @GetMapping("/lookup/{branchCode}")
    public ResponseEntity<BranchProfile> getByCode(
            @PathVariable String branchCode) {
        return ResponseEntity.ok(service.findByBranchCode(branchCode));
    }
}
