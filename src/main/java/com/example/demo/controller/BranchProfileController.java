package com.example.demo.controller;

import com.example.demo.entity.BranchProfile;
import com.example.demo.service.BranchProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
@Tag(name = "Branch Profiles")
public class BranchProfileController {

    private final BranchProfileService branchProfileService;

    public BranchProfileController(BranchProfileService branchProfileService) {
        this.branchProfileService = branchProfileService;
    }

    @PostMapping
    public ResponseEntity<BranchProfile> createBranch(@RequestBody BranchProfile branch) {
        return ResponseEntity.ok(branchProfileService.createBranch(branch));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<BranchProfile> updateBranchStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {

        return ResponseEntity.ok(branchProfileService.updateBranchStatus(id, active));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchProfile> getBranchById(@PathVariable Long id) {
        return ResponseEntity.ok(branchProfileService.getBranchById(id));
    }

    @GetMapping
    public ResponseEntity<List<BranchProfile>> getAllBranches() {
        return ResponseEntity.ok(branchProfileService.getAllBranches());
    }

    @GetMapping("/lookup/{branchCode}")
    public ResponseEntity<BranchProfile> getByBranchCode(@PathVariable String branchCode) {
        return ResponseEntity.ok(branchProfileService.findByBranchCode(branchCode));
    }
}
