package com.example.demo.web.controllers;

import com.example.demo.web.dto.request.ChecklistRequestDTO;
import com.example.demo.web.dto.response.ApiResponseDTO;

import com.example.demo.service.ChecklistService;
import com.example.demo.web.dto.response.ChecklistResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/checklists")
public class ChecklistController {
    @Autowired
    private ChecklistService checklistService;

    @GetMapping
    public ResponseEntity<List<ChecklistResponseDTO>> getAll() {
        return ResponseEntity.ok(checklistService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChecklistResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(checklistService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO> create(@RequestBody ChecklistRequestDTO dto) {
        checklistService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponseDTO(true, "Checklist criado com sucesso"));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ChecklistResponseDTO> edit(@PathVariable UUID id, @RequestBody ChecklistRequestDTO checklistRequestDTO) {
        return ResponseEntity.ok(checklistService.editById(id, checklistRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> delete(@PathVariable UUID id) {
        checklistService.deleteById(id);
        return ResponseEntity.ok(new ApiResponseDTO(true, "Checklist deletado com sucesso"));
    }
}
