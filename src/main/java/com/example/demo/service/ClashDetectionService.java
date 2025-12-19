package com.example.demo.service;

import com.example.demo.entity.ClashRecord;
import java.util.List;

public interface ClashDetectionService {
    ClashRecord save(ClashRecord clash);
    List<ClashRecord> getAll();
    ClashRecord getById(Long id);
}
