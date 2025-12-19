package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ClashRecord;

public interface ClashRecordService {
    ClashRecord save(ClashRecord clash);
    List<ClashRecord> getAll();
}
