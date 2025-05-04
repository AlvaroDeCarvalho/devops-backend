package com.example.demo.infrastruture.repository;

import com.example.demo.Entity.ChecklistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChecklistRepository extends JpaRepository<ChecklistEntity, UUID> {
}
