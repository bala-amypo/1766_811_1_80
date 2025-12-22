package com.example.demo.service;

import com.example.demo.entity.BranchProfile;

import java.util.List;

public interface BranchProfileService {

    BranchProfile createBranch(BranchProfile branch);

    BranchProfile updateBranchStatus(Long id, boolean active);

    BranchProfile getBranchById(Long id);

    List<BranchProfile> getAllBranches();

    BranchProfile getByBranchCode(String branchCode);
}
