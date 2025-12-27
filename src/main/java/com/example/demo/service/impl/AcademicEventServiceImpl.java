/*package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    private final AcademicEventRepository repository;

    public AcademicEventServiceImpl(AcademicEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public AcademicEvent submit(AcademicEvent event) {
        return repository.save(event);
    }

    @Override
    public List<AcademicEvent> getByBranch(Long branchId) {
        return repository.findByBranchId(branchId);
    }

    @Override
    public List<AcademicEvent> findByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }
}
*/
package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    private final AcademicEventRepository repository;

    public AcademicEventServiceImpl(AcademicEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public AcademicEvent submit(AcademicEvent event) {

        if (event.getStartDate() == null || event.getEndDate() == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }

        if (event.getStartDate().isAfter(event.getEndDate())) {
            throw new IllegalArgumentException("startDate cannot be after endDate");
        }

        return repository.save(event);
    }

    @Override
    public List<AcademicEvent> getByBranch(Long branchId) {
        return repository.findByBranchId(branchId);
    }

    @Override
    public List<AcademicEvent> findByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }
}
