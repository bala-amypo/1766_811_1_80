// BranchProfileService.java
package com.example.demo.service;

import com.example.demo.entity.BranchProfile;
import java.util.List;

public interface BranchProfileService {
    BranchProfile create(BranchProfile branchProfile);
    BranchProfile update(Long id, BranchProfile branchProfile);
    BranchProfile getById(Long id);
    List<BranchProfile> getAll();
    void delete(Long id);
}
