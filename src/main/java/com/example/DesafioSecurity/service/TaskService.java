package com.example.DesafioSecurity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.DesafioSecurity.dto.TaskRequest;
import com.example.DesafioSecurity.dto.TaskResponse;
import com.example.DesafioSecurity.dto.TaskUpdateRequest;
import com.example.DesafioSecurity.enums.PriorityTask;
import com.example.DesafioSecurity.enums.StatusTask;
import com.example.DesafioSecurity.mapper.TaskMapper;
import com.example.DesafioSecurity.model.Project;
import com.example.DesafioSecurity.model.Task;
import com.example.DesafioSecurity.repository.ProjectRepository;
import com.example.DesafioSecurity.repository.TaskRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final ProjectRepository projectRepository;

    public TaskService(TaskRepository t, TaskMapper m, ProjectRepository p) {
        this.taskRepository = t;
        this.taskMapper = m;
        this.projectRepository = p;
    }

    public TaskResponse criar(TaskRequest request) {
        Project project = projectRepository.findById(request.idProject())
                .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado!"));
        Task task = taskMapper.toEntity(request, project);
        taskRepository.save(task);
        return taskMapper.toResponse(task);
    }

    public List<TaskResponse> buscarPorFiltro(Long idProject,Long id, StatusTask status, PriorityTask priority) {
        return taskRepository.findByFiltro(status, priority, idProject,id)
                .stream()
                .map(taskMapper::toResponse)
                .toList();
    }

    public TaskResponse atualizarStatus(Long id, TaskUpdateRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada!"));
        task.setStatus(request.status());
        taskRepository.save(task);
        return taskMapper.toResponse(task);
    }

    public void deletarPorId(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new EntityNotFoundException("Tarefa não encontrada!");
        }
        taskRepository.deleteById(id);
    }

}
