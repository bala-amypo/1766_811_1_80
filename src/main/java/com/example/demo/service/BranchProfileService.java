package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.BranchProfile;

public interface BranchProfileService {
    BranchProfile save(BranchProfile branch);
    List<BranchProfile> getAll();
}
