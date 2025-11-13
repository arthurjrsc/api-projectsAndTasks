package com.example.DesafioSecurity.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProjectRequest(
        @NotBlank(message = "O nome é obrigatório") String name,
        @NotBlank(message = "A descrição é obrigatória") String description,
        @NotNull(message = "A data final é obrigatória") 
        @Future(message = "A data final deve ser futura")
        LocalDate endDate) {

}
