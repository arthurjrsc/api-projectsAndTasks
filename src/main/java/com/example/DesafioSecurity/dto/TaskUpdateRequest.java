package com.example.DesafioSecurity.dto;

import com.example.DesafioSecurity.enums.StatusTask;

import jakarta.validation.constraints.NotNull;

public record TaskUpdateRequest(@NotNull(message = "O status é obrigatório")StatusTask status) {
    
}
