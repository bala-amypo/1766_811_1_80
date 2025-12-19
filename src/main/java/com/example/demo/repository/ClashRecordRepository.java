package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ClashRecord;

public interface ClashRecordRepository extends JpaRepository<ClashRecord, Long> {
}
