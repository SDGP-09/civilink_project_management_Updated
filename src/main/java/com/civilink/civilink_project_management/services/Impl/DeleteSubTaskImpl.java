package com.civilink.civilink_project_management.services.Impl;

import com.civilink.civilink_project_management.entities.MainTask;
import com.civilink.civilink_project_management.entities.SubTask;
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
        Optional<SubTask> subTask = subTaskRepository.findById(id);

        if (subTask.isPresent()) {
            subTaskRepository.deleteById(id);
        } else {
            throw new RuntimeException("SubTask with ID " + id + " not found.");
        }
    }

    // Delete all subtasks of a specific main task
    @Override
    @Transactional
    public void deleteAllSubTasks(Long mainTaskId) {
        Optional<MainTask> mainTask = mainTaskRepository.findById(mainTaskId);

        if (mainTask.isPresent()) {
            System.out.println("Deleting SubTask: " );
            subTaskRepository.deleteAllByMainTask(mainTask.get());
        } else {
            throw new RuntimeException("MainTask with ID " + mainTaskId + " not found.");
        }
    }
}

