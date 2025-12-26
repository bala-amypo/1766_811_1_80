package com.example.demo.repository;

import com.example.demo.entity.ClashRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClashRecordRepository extends JpaRepository<ClashRecord, Long> {

    // Find clashes involving a specific event
    List<ClashRecord> findByEventAIdOrEventBId(Long eventAId, Long eventBId);

    // Find unresolved clashes
    List<ClashRecord> findByResolvedFalse();
}
