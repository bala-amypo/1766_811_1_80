package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BranchProfile;
import com.example.demo.service.BranchProfileService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/branches")
public class BranchProfileController {

    private final BranchProfileService branchProfileService;

    public BranchProfileController(BranchProfileService branchProfileService) {
        this.branchProfileService = branchProfileService;
    }

    @PostMapping
    public BranchProfile createBranch(@Valid @RequestBody BranchProfile branch) {
        return branchProfileService.save(branch);
    }

    @GetMapping
    public List<BranchProfile> getAllBranches() {
        return branchProfileService.getAll();
    }
}
