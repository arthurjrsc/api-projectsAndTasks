package com.example.DesafioSecurity.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DesafioSecurity.dto.TaskRequest;
import com.example.DesafioSecurity.dto.TaskResponse;
import com.example.DesafioSecurity.dto.TaskUpdateRequest;
import com.example.DesafioSecurity.enums.PriorityTask;
import com.example.DesafioSecurity.enums.StatusTask;
import com.example.DesafioSecurity.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService t) {
        this.taskService = t;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> criar(@Valid @RequestBody TaskRequest request) {
        TaskResponse task = taskService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> buscarPorFiltro(@RequestParam(required = false) StatusTask status,@RequestParam(required = false) PriorityTask priority,@RequestParam(required = false) Long idProject,@RequestParam(required = false) Long id) {
        List<TaskResponse> tasks = taskService.buscarPorFiltro(idProject,id,status, priority);
        if (tasks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tasks);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TaskResponse> atualizarStatus(@PathVariable Long id, @Valid @RequestBody TaskUpdateRequest updateRequest){
        TaskResponse task = taskService.atualizarStatus(id, updateRequest);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id){
        taskService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
