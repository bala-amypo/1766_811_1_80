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
*/
package com.example.demo.service.impl;

import com.example.demo.entity.BranchProfile;
import com.example.demo.repository.BranchProfileRepository;
import com.example.demo.service.BranchProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchProfileServiceImpl implements BranchProfileService {

    private final BranchProfileRepository repository;

    public BranchProfileServiceImpl(BranchProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public BranchProfile save(BranchProfile branchProfile) {
        return repository.save(branchProfile);
    }

    @Override
    public List<BranchProfile> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<BranchProfile> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}


