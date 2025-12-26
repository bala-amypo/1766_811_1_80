package com.example.demo.service.impl;

import com.example.demo.entity.ClashRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ClashRecordRepository;
import com.example.demo.service.ClashDetectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClashDetectionServiceImpl implements ClashDetectionService {

    private final ClashRecordRepository clashRecordRepository;

    public ClashDetectionServiceImpl(ClashRecordRepository clashRecordRepository) {
        this.clashRecordRepository = clashRecordRepository;
    }

    @Override
    public ClashRecord createClash(ClashRecord clashRecord) {
        return clashRecordRepository.save(clashRecord);
    }

    @Override
    public ClashRecord updateClash(Long id, ClashRecord clashRecord) {
        ClashRecord existing = getClashById(id);
        existing.setBranchCode(clashRecord.getBranchCode());
        existing.setEventDate(clashRecord.getEventDate());
        existing.setEventType(clashRecord.getEventType());
        existing.setDescription(clashRecord.getDescription());
        return clashRecordRepository.save(existing);
    }

    @Override
    public ClashRecord getClashById(Long id) {
        return clashRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clash record not found"));
    }

    @Override
    public List<ClashRecord> getAllClashes() {
        return clashRecordRepository.findAll();
    }

    @Override
    public void deleteClash(Long id) {
        ClashRecord clash = getClashById(id);
        clashRecordRepository.delete(clash);
    }
}
