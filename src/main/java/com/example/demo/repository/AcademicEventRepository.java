package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AcademicEvent;

public interface AcademicEventRepository extends JpaRepository<AcademicEvent, Long> {
}
