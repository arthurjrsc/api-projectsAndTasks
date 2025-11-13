package com.example.DesafioSecurity.dto;

import java.time.LocalDate;

import com.example.DesafioSecurity.enums.PriorityTask;
import com.example.DesafioSecurity.enums.StatusTask;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskRequest(
        @NotNull(message = "O id do projeto correspondente é obrigatório") Long idProject,
        @NotBlank(message = "O titulo é obrigatório") String title,
        @NotBlank(message = "A descrição é obrigatório") String description,
        @NotNull(message = "A data limite é obrigatória") 
        @Future(message = "A data final deve ser futura")
        LocalDate dueDate,
        @NotNull(message = "O nivel de prioridade é obrigatório") PriorityTask priority,
        @NotNull(message = "O status é obrigatório") StatusTask status) {

}
