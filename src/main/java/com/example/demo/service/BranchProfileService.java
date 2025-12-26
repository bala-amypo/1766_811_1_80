/*package com.example.demo.service;

import com.example.demo.entity.BranchProfile;

import java.util.List;

public interface BranchProfileService {

    BranchProfile save(BranchProfile profile);

    List<BranchProfile> findAll();

    BranchProfile deactivate(Long id);
}
*/
package com.example.demo.service;

import com.example.demo.entity.BranchProfile;

import java.util.List;
import java.util.Optional;

public interface BranchProfileService {

    BranchProfile save(BranchProfile branchProfile);

    List<BranchProfile> findAll();

    Optional<BranchProfile> findById(Long id);

    void deleteById(Long id);
}
