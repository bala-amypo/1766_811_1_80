package com.example.demo.controller;

import com.example.demo.entity.BranchProfile;
import com.example.demo.service.impl.BranchProfileServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchProfileController {

    private final BranchProfileServiceImpl branchProfileService;

    public BranchProfileController(BranchProfileServiceImpl branchProfileService) {
        this.branchProfileService = branchProfileService;
    }

    @PostMapping
    public ResponseEntity<BranchProfile> createBranch(@RequestBody BranchProfile branchProfile) {
        BranchProfile created = branchProfileService.createBranch(branchProfile);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<BranchProfile> updateBranchStatus(
            @PathVariable Long id, @RequestParam Boolean active) {
        BranchProfile updated = branchProfileService.updateBranchStatus(id, active);
        return ResponseEntity.ok(updated);
    }

    @GetMapping
    public ResponseEntity<List<BranchProfile>> getAllBranches() {
        List<BranchProfile> list = branchProfileService.getAllBranches();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchProfile> getBranchById(@PathVariable Long id) {
        BranchProfile branch = branchProfileService.getBranchById(id);
        return ResponseEntity.ok(branch);
    }
}
