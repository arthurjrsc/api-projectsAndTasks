package com.example.DesafioSecurity.mapper;

import org.springframework.stereotype.Component;

import com.example.DesafioSecurity.dto.TaskRequest;
import com.example.DesafioSecurity.dto.TaskResponse;
import com.example.DesafioSecurity.model.Project;
import com.example.DesafioSecurity.model.Task;

@Component
public class TaskMapper {

    public Task toEntity(TaskRequest request, Project project) {
        Task task = new Task();
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setDueDate(request.dueDate());
        task.setPriority(request.priority());
        task.setStatus(request.status());
        task.setProject(project);
        return task;
    }

    public TaskResponse toResponse(Task t) {
        return new TaskResponse(t.getProject().getId(), t.getProject().getName(), t.getId(), t.getTitle(),
                t.getDescription(), t.getStartDate(), t.getDueDate(), t.getPriority(), t.getStatus());
    }
}
