package com.example.demo.service;

import com.example.demo.Entity.ChecklistEntity;
import com.example.demo.web.dto.request.ChecklistFiltroDTO;
import com.example.demo.web.dto.request.ChecklistRequestDTO;
import com.example.demo.web.dto.response.ApiResponseDTO;
import com.example.demo.web.dto.response.ChecklistResponseDTO;
import com.example.demo.infrastruture.repository.ChecklistRepository;
import com.example.demo.service.imp.ChecklistInterface;
import com.example.demo.web.mapper.ChecklistMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;

@Service
public class ChecklistService implements ChecklistInterface {
    @Autowired
    private ChecklistRepository checklistRepository;

    @Override
    public Page<ChecklistResponseDTO> filtrar(ChecklistFiltroDTO checklistFiltroDTO, Pageable pageable) {
        LocalDate dataInicial = YearMonth.parse(checklistFiltroDTO.dataInicial()).atDay(1);
        LocalDate dataFinal = YearMonth.parse(checklistFiltroDTO.dataFinal()).atEndOfMonth();
        Page<ChecklistEntity> checklistFilter = checklistRepository.buscarPorPeriodo(dataInicial, dataFinal, pageable);
        return checklistFilter.map(ChecklistMapper::toDTO);
        }

    @Override
    public Page<ChecklistResponseDTO> findAll(Pageable pageable) {
        return checklistRepository.findAll(pageable)
                .map(ChecklistMapper::toDTO);
    }

    @Override
    public ChecklistResponseDTO findById(UUID id) {
        ChecklistEntity checklistEntity = checklistRepository.findById(id).orElseThrow();
        ChecklistResponseDTO checklistResponseDTO = ChecklistMapper.toDTO(checklistEntity);
        return checklistResponseDTO;
    }

    @Override
    public void create(@RequestBody ChecklistRequestDTO checklistRequestDTO) {
        ChecklistEntity checklistEntity = ChecklistMapper.toEntity(checklistRequestDTO);
        checklistRepository.save(checklistEntity);
        ResponseEntity.ok(
                new ApiResponseDTO(true, "Checklist criado com sucesso")
        );
    }

    @Override
    public ChecklistResponseDTO editById(UUID id, ChecklistRequestDTO checklistRequestDTO) {
        ChecklistEntity existingChecklist = checklistRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Checklist não encontrada com o ID: " + id));

        existingChecklist.setMessage(checklistRequestDTO.message());
        existingChecklist.setAtUpdate(new Date());

        ChecklistEntity updatedChecklist = checklistRepository.save(existingChecklist);

        return ChecklistMapper.toDTO(updatedChecklist);
    }

    @Override
    public void deleteById(UUID id) {
        checklistRepository.deleteById(id);
    }

}
