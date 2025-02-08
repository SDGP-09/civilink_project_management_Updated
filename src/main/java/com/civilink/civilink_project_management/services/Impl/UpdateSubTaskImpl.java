package com.civilink.civilink_project_management.services.Impl;

import com.civilink.civilink_project_management.dtos.requests.RequestSubTaskDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseSubTaskDto;
import com.civilink.civilink_project_management.entities.MainTask;
import com.civilink.civilink_project_management.entities.SubTask;
import com.civilink.civilink_project_management.repositories.MainTaskRepository;
import com.civilink.civilink_project_management.repositories.SubTaskRepository;
import com.civilink.civilink_project_management.services.UpdateSubTaskService;
import com.civilink.civilink_project_management.util.SubtaskUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateSubTaskImpl implements UpdateSubTaskService {

    private final SubTaskRepository subTaskRepository;
    private final MainTaskRepository mainTaskRepository;
    private final SubtaskUtil subtaskUtil;

    @Autowired
    public UpdateSubTaskImpl(SubTaskRepository subTaskRepository, MainTaskRepository mainTaskRepository, SubtaskUtil subtaskUtil) {
        this.subTaskRepository = subTaskRepository;
        this.mainTaskRepository = mainTaskRepository;
        this.subtaskUtil = subtaskUtil;
    }

    @Override
    public ResponseSubTaskDto updateSubTask(Long subTaskId, RequestSubTaskDto requestSubTaskDto) {

        // Fetch the existing SubTask
        SubTask existingsubTask = subTaskRepository.findById(subTaskId)
                .orElseThrow(() -> new RuntimeException("Subtask not found with id: " + subTaskId));

        //fetch and set the MainTask
        if (requestSubTaskDto.getMainTaskId() != null) {
            MainTask mainTask = mainTaskRepository.findById(requestSubTaskDto.getMainTaskId())
                    .orElseThrow(() -> new RuntimeException("Main task not found with id: " + requestSubTaskDto.getMainTaskId()));
            existingsubTask.setMainTask(mainTask);
        }

        // update fields
        if (requestSubTaskDto.getTaskname() != null) {
            existingsubTask.setTaskname(requestSubTaskDto.getTaskname());
        }
        if (requestSubTaskDto.getStatus() != null) {
            existingsubTask.setStatus(requestSubTaskDto.getStatus());
        }
        if (requestSubTaskDto.getStartDate() != null) {
            existingsubTask.setStartDate(requestSubTaskDto.getStartDate());
        }
        if (requestSubTaskDto.getEndDate() != null) {
            existingsubTask.setEndDate(requestSubTaskDto.getEndDate());
        }
        if (requestSubTaskDto.getDescription() != null) {
            existingsubTask.setDescription(requestSubTaskDto.getDescription());
        }

        // Save the updated SubTask
        SubTask updatedSubTask = subTaskRepository.save(existingsubTask);

        // Convert to response DTO
        return subtaskUtil.convertToResponseSubTaskDto(updatedSubTask);
    }
}
