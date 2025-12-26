package com.example.demo.controller;

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
