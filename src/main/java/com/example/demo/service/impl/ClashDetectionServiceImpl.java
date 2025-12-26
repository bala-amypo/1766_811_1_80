package com.example.demo.service.impl;

import com.example.demo.entity.ClashRecord;
import com.example.demo.repository.ClashRecordRepository;
import com.example.demo.service.ClashDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClashDetectionServiceImpl implements ClashDetectionService {

    @Autowired
    private ClashRecordRepository clashRepository;

    @Override
    public List<ClashRecord> getClashesForEvent(Long eventId) {
        return clashRepository.findByEventId(eventId);
    }

    @Override
    public List<ClashRecord> getUnresolvedClashes() {
        return clashRepository.findByResolved(false);
    }

    @Override
    public ClashRecord resolveClash(Long id) {
        ClashRecord clash = clashRepository.findById(id).orElse(null);
        if(clash != null) {
            clash.setResolved(true);
            return clashRepository.save(clash);
        }
        return null;
    }
}
