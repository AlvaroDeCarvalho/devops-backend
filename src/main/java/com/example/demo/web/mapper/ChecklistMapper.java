package com.example.demo.web.mapper;

import com.example.demo.Entity.ChecklistEntity;
import com.example.demo.web.dto.request.ChecklistRequestDTO;
import com.example.demo.web.dto.response.ChecklistResponseDTO;


import java.util.Date;

public class ChecklistMapper {

    public static ChecklistResponseDTO toDTO(ChecklistEntity entity) {
        if (entity == null) return null;

        return new ChecklistResponseDTO(
                entity.getId(),
                entity.getMessage(),
                entity.getAtCreate(),
                entity.getAtUpdate(),
                entity.getAtDelete()
        );
    }

    public static ChecklistEntity toEntity(ChecklistRequestDTO dto) {
        Date now = new Date();
        return new ChecklistEntity(
                null,
                dto.message(),
                now,
                now,
                null
        );
    }
}

