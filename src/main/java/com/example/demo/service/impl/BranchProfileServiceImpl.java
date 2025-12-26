/*package com.example.demo.service.impl;

import com.example.demo.entity.BranchProfile;
import com.example.demo.repository.BranchProfileRepository;
import com.example.demo.service.BranchProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchProfileServiceImpl implements BranchProfileService {

    private final BranchProfileRepository repository;

    public BranchProfileServiceImpl(BranchProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public BranchProfile save(BranchProfile profile) {
        return repository.save(profile);
    }

    @Override
    public List<BranchProfile> findAll() {
        return repository.findAll();
    }

    @Override
    public BranchProfile deactivate(Long id) {
        BranchProfile bp = repository.findById(id).orElseThrow();
        bp.setActive(false);
        return repository.save(bp);
    }
}
