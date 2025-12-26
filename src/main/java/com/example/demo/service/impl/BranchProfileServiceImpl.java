package com.example.demo.service.impl;

import com.example.demo.entity.BranchProfile;
import com.example.demo.repository.BranchProfileRepository;
import com.example.demo.service.BranchProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchProfileServiceImpl implements BranchProfileService {

    @Autowired
    private BranchProfileRepository branchProfileRepository;

    @Override
    public BranchProfile createBranch(BranchProfile branchProfile) {
        return branchProfileRepository.save(branchProfile);
    }

    @Override
    public BranchProfile updateBranchStatus(Long id, Boolean active) {
        BranchProfile branch = branchProfileRepository.findById(id).orElse(null);
        if(branch != null) {
            branch.setActive(active);
            return branchProfileRepository.save(branch);
        }
        return null;
    }

    @Override
    public List<BranchProfile> getAllBranches() {
        return branchProfileRepository.findAll();
    }

    @Override
    public BranchProfile getBranchById(Long id) {
        return branchProfileRepository.findById(id).orElse(null);
    }
}
