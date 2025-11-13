package com.example.DesafioSecurity.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DesafioSecurity.dto.ProjectRequest;
import com.example.DesafioSecurity.dto.ProjectResponse;
import com.example.DesafioSecurity.service.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService s) {
        this.projectService = s;
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> criar(@Valid @RequestBody ProjectRequest request) {
        ProjectResponse project = projectService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponse>> listarTodos() {
        List<ProjectResponse> projects = projectService.listarTodos();
        if (projects.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(projects);
    }
}
