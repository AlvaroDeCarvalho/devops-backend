package com.example.demo.service.imp;

import com.example.demo.web.dto.request.ChecklistFiltroDTO;
import com.example.demo.web.dto.request.ChecklistRequestDTO;
import com.example.demo.web.dto.response.ChecklistResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.UUID;

public interface ChecklistInterface {

    Page<ChecklistResponseDTO> filtrar(ChecklistFiltroDTO checklistFiltroDTO, Pageable pageable);

    Page<ChecklistResponseDTO> findAll(Pageable pageable);

    ChecklistResponseDTO findById(UUID id);

    void create(@RequestBody ChecklistRequestDTO checklistRequestDTO);

    ChecklistResponseDTO editById(@PathVariable UUID id, @RequestBody ChecklistRequestDTO checklistRequestDTO);

    void deleteById(UUID id);
}
