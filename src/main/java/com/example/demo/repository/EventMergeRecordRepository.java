// EventMergeRecordRepository.java
package com.example.demo.repository;

import com.example.demo.entity.EventMergeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventMergeRecordRepository extends JpaRepository<EventMergeRecord, Long> {}
