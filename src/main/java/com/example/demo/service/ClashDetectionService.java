// ClashRecordService.java
package com.example.demo.service;

import com.example.demo.entity.ClashRecord;
import java.util.List;

public interface ClashRecordService {
    ClashRecord create(ClashRecord record);
    ClashRecord update(Long id, ClashRecord record);
    ClashRecord getById(Long id);
    List<ClashRecord> getAll();
    void delete(Long id);
}
