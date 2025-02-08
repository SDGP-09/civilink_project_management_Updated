package com.civilink.civilink_project_management.services.Impl;


import com.civilink.civilink_project_management.exception.MainTaskNotFoundException;
import com.civilink.civilink_project_management.repositories.MainTaskRepository;
import com.civilink.civilink_project_management.repositories.SubTaskRepository;
import com.civilink.civilink_project_management.services.DeleteSubTaskService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class DeleteSubTaskImpl implements DeleteSubTaskService {

    private final SubTaskRepository subTaskRepository;
    private final MainTaskRepository mainTaskRepository;

    @Autowired
    public DeleteSubTaskImpl(SubTaskRepository subTaskRepository, MainTaskRepository mainTaskRepository) {
        this.subTaskRepository = subTaskRepository;
        this.mainTaskRepository = mainTaskRepository;
    }

    // Delete a subtask by ID
    @Override
    @Transactional
    public void deleteSubTask(Long id) {
        if (!subTaskRepository.existsById(id)) {
            throw new RuntimeException("SubTask with ID " + id + " not found.");
        }
        subTaskRepository.deleteSubTaskById(id);
    }

    // Delete all subtasks of a specific main task
    @Override
    @Transactional
    public void deleteAllSubTasks(Long mainTaskId) {
        if (!mainTaskRepository.existsById(mainTaskId)) {
            throw new MainTaskNotFoundException("MainTask with ID " + mainTaskId + " not found.");
        }
        subTaskRepository.deleteAllSubTasksByMainTask(mainTaskId);
    }
}

