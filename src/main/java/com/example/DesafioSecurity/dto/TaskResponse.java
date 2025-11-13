package com.example.DesafioSecurity.dto;

import java.time.LocalDate;

import com.example.DesafioSecurity.enums.PriorityTask;
import com.example.DesafioSecurity.enums.StatusTask;

public record TaskResponse(
        Long idProject,
        String nameProject,
        Long idTask,
        String title,
        String description,
        LocalDate startDate,
        LocalDate dueDate,
        PriorityTask priority,
        StatusTask status) {

}
