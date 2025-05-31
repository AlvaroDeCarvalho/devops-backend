package com.example.demo.infrastruture.repository;

import com.example.demo.Entity.ChecklistEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ChecklistRepository extends JpaRepository<ChecklistEntity, UUID> {

    @Query(value = """
            SELECT * FROM checklist c WHERE c.at_create BETWEEN :dataInicial AND :dataFinal
            """, nativeQuery = true)
     public Page<ChecklistEntity> buscarPorPeriodo(
            @Param("dataInicial") LocalDate dataInicial,
            @Param("dataFinal") LocalDate dataFinal,
            Pageable pageable
            );

}
