package com.example.demo.web.dto.response;

import java.util.Date;
import java.util.UUID;

public record ChecklistResponseDTO(
        UUID Id,
        String message,
        Date atCreate,
        Date atUpdate,
        Date atDelete
) {

}
