package com.example.demo.service.impl;

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

    public BranchProfile save(BranchProfile branch) {
        return repository.save(branch);
    }

    public List<BranchProfile> getAll() {
        return repository.findAll();
    }

    public BranchProfile getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
