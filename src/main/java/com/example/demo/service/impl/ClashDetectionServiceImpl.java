package com.example.demo.service.impl;

import com.example.demo.entity.ClashRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ClashRecordRepository;
import com.example.demo.service.ClashDetectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClashDetectionServiceImpl implements ClashDetectionService {

    private final ClashRecordRepository repository;

    public ClashDetectionServiceImpl(ClashRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClashRecord createClash(ClashRecord clashRecord) {
        return repository.save(clashRecord);
    }

    @Override
    public ClashRecord updateClash(Long id, ClashRecord clashRecord) {
        ClashRecord existing = getClashById(id);
        return repository.save(existing);
    }

    @Override
    public ClashRecord getClashById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ClashRecord not found"));
    }

    @Override
    public List<ClashRecord> getAllClashes() {
        return repository.findAll();
    }

    @Override
    public void deleteClash(Long id) {
        repository.deleteById(id);
    }
}
