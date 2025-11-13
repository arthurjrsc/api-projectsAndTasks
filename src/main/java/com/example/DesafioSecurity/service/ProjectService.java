package com.example.DesafioSecurity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.DesafioSecurity.dto.ProjectRequest;
import com.example.DesafioSecurity.dto.ProjectResponse;
import com.example.DesafioSecurity.mapper.ProjectMapper;
import com.example.DesafioSecurity.model.Project;
import com.example.DesafioSecurity.repository.ProjectRepository;

@Service
public class ProjectService {
    
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectService(ProjectRepository r,ProjectMapper p){
        this.projectRepository = r;
        this.projectMapper = p;
    }

    public ProjectResponse criar(ProjectRequest request){
        Project project = projectMapper.toEntity(request);
        projectRepository.save(project);
        return projectMapper.toResponse(project);
    }

    public List<ProjectResponse> listarTodos(){
        return projectRepository.findAll()
        .stream()
        .map(projectMapper::toResponse)
        .toList();
    }
}
