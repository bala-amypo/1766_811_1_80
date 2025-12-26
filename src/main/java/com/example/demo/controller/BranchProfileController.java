package com.example.demo.controller;

import com.example.demo.entity.BranchProfile;
import com.example.demo.service.BranchProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchProfileController {

    @Autowired
    private BranchProfileService branchProfileService;

    @PostMapping
    public ResponseEntity<BranchProfile> createBranch(@RequestBody BranchProfile branch) {
        return ResponseEntity.ok(branchProfileService.create(branch));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BranchProfile> updateBranch(@PathVariable Long id, @RequestBody BranchProfile branch) {
        return ResponseEntity.ok(branchProfileService.update(id, branch));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchProfile> getBranch(@PathVariable Long id) {
        return ResponseEntity.ok(branchProfileService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<BranchProfile>> getAllBranches() {
        return ResponseEntity.ok(branchProfileService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBranch(@PathVariable Long id) {
        branchProfileService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
