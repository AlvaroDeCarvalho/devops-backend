package com.example.demo.service.imp;

import com.example.demo.web.dto.request.ChecklistRequestDTO;
import com.example.demo.web.dto.response.ChecklistResponseDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface ChecklistInterface {

    List<ChecklistResponseDTO> findAll();

    ChecklistResponseDTO findById(UUID id);

    void create(@RequestBody ChecklistRequestDTO checklistRequestDTO);

    ChecklistResponseDTO editById(@PathVariable UUID id, @RequestBody ChecklistRequestDTO checklistRequestDTO);

    void deleteById(UUID id);
}
