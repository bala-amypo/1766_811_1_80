// ClashRecordServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.ClashRecord;
import com.example.demo.repository.ClashRecordRepository;
import com.example.demo.service.ClashRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClashRecordServiceImpl implements ClashRecordService {

    @Autowired
    private ClashRecordRepository repository;

    @Override
    public ClashRecord create(ClashRecord record) { return repository.save(record); }

    @Override
    public ClashRecord update(Long id, ClashRecord record) {
        record.setId(id);
        return repository.save(record);
    }

    @Override
    public ClashRecord getById(Long id) { return repository.findById(id).orElse(null); }

    @Override
    public List<ClashRecord> getAll() { return repository.findAll(); }

    @Override
    public void delete(Long id) { repository.deleteById(id); }
}
