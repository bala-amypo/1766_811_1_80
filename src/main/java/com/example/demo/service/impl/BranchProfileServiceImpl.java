// BranchProfileServiceImpl.java
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
    private BranchProfileRepository repository;

    @Override
    public BranchProfile create(BranchProfile branchProfile) { return repository.save(branchProfile); }

    @Override
    public BranchProfile update(Long id, BranchProfile branchProfile) {
        branchProfile.setId(id);
        return repository.save(branchProfile);
    }

    @Override
    public BranchProfile getById(Long id) { return repository.findById(id).orElse(null); }

    @Override
    public List<BranchProfile> getAll() { return repository.findAll(); }

    @Override
    public void delete(Long id) { repository.deleteById(id); }
}
