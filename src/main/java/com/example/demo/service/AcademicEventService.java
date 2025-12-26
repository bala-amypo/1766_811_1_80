/*package com.example.demo.service;

import com.example.demo.entity.AcademicEvent;

import java.util.List;

public interface AcademicEventService {

    AcademicEvent submit(AcademicEvent event);

    List<AcademicEvent> getByBranch(Long branchId);

    List<AcademicEvent> findByIds(List<Long> ids);
}
*/
package com.example.demo.service;

import com.example.demo.entity.AcademicEvent;

import java.util.List;
import java.util.Optional;

public interface AcademicEventService {

    AcademicEvent save(AcademicEvent academicEvent);

    List<AcademicEvent> findAll();

    Optional<AcademicEvent> findById(Long id);

    List<AcademicEvent> findByBranchId(Long branchId);

    void deleteById(Long id);
}

