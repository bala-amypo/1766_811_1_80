package com.example.demo.service;

import com.example.demo.entity.ClashRecord;

import java.util.List;

public interface ClashDetectionService {

    ClashRecord createClash(ClashRecord clashRecord);

    ClashRecord updateClash(Long id, ClashRecord clashRecord);

    ClashRecord getClashById(Long id);

    List<ClashRecord> getAllClashes();

    void deleteClash(Long id);
}
