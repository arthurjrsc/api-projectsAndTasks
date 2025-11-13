package com.example.DesafioSecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.DesafioSecurity.enums.PriorityTask;
import com.example.DesafioSecurity.enums.StatusTask;
import com.example.DesafioSecurity.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("""
            select t from Task t
            where (:status IS NULL or t.status = :status)
            and (:priority IS NULL or t.priority = :priority)
            and (:idProject IS NULL or t.project.id = :idProject)
            and (:id IS NULL or t.id = :id)""")
    List<Task> findByFiltro(
            @Param("status") StatusTask status,
            @Param("priority") PriorityTask priority,
            @Param("idProject") Long idProject,
            @Param("id") Long id);

}
