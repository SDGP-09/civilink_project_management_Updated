package com.civilink.civilink_project_management.services.Impl;

import com.civilink.civilink_project_management.entities.MainTask;
import com.civilink.civilink_project_management.exception.MainTaskNotFoundException;
import com.civilink.civilink_project_management.repositories.MainTaskRepository;
import com.civilink.civilink_project_management.services.DeleteMainTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteMainTaskImpl implements DeleteMainTaskService {
    private final MainTaskRepository mainTaskRepository;

    @Autowired
    public DeleteMainTaskImpl(MainTaskRepository mainTaskRepository) {
        this.mainTaskRepository = mainTaskRepository;
    }

    //delete main task using id
    @Override
    public void deleteMainTask(Long id) {
        Optional<MainTask> mainTask = mainTaskRepository.findById(id);

        if (mainTask.isPresent()) {
            mainTaskRepository.deleteById(id);
        } else {
            throw new MainTaskNotFoundException("MainTask with ID " + id + " not found.");
        }
    }

    //delete all main tasks
    @Override
    public void deleteAllMainTasks() {
        mainTaskRepository.deleteAll();
    }
}

