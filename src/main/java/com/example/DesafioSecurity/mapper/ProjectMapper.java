package com.example.DesafioSecurity.mapper;

import org.springframework.stereotype.Component;

import com.example.DesafioSecurity.dto.ProjectRequest;
import com.example.DesafioSecurity.dto.ProjectResponse;
import com.example.DesafioSecurity.model.Project;

@Component
public class ProjectMapper {

    public Project toEntity(ProjectRequest request) {
        Project project = new Project();
        project.setName(request.name());
        project.setDescription(request.description());
        project.setEndDate(request.endDate());
        return project;
    }

    public ProjectResponse toResponse(Project p) {
        return new ProjectResponse(p.getId(), p.getName(), p.getDescription(), p.getStartDate(), p.getEndDate());
    }
}
