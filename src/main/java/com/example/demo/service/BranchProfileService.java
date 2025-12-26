package com.example.demo.service;

import com.example.demo.entity.BranchProfile;

import java.util.List;

public interface BranchProfileService {

    BranchProfile save(BranchProfile profile);

    List<BranchProfile> findAll();

    BranchProfile deactivate(Long id);
}
