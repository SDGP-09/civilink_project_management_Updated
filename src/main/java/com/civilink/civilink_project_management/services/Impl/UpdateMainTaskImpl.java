package com.civilink.civilink_project_management.services.Impl;

import com.civilink.civilink_project_management.dtos.requests.RequestMainTaskDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseMainTaskDto;
import com.civilink.civilink_project_management.entities.Contractor;
import com.civilink.civilink_project_management.entities.MainTask;
import com.civilink.civilink_project_management.repositories.ContractorRepository;
import com.civilink.civilink_project_management.repositories.MainTaskRepository;
import com.civilink.civilink_project_management.services.UpdateMainTaskService;
import com.civilink.civilink_project_management.util.ContractorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateMainTaskImpl implements UpdateMainTaskService {
    private final MainTaskRepository mainTaskRepository;
    private final ContractorRepository contractorRepository;
    private final ContractorUtil contractorUtil;

    @Autowired
    public UpdateMainTaskImpl(MainTaskRepository mainTaskRepository, ContractorRepository contractorRepository, ContractorUtil contractorUtil) {
        this.mainTaskRepository = mainTaskRepository;
        this.contractorRepository = contractorRepository;
        this.contractorUtil = contractorUtil;
    }

    @Override
    public ResponseMainTaskDto updateMainTask(Long taskId, RequestMainTaskDto requestMainTaskDto) {

        // Retrieve the existing main task
        MainTask existingTask = mainTaskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Main Task not found with id: " + taskId));

        // Check if contractor needs to be updated
        if (requestMainTaskDto.getContractorId() != null) {
            Contractor contractor = contractorRepository.findById(requestMainTaskDto.getContractorId())
                    .orElseThrow(() -> new RuntimeException("Contractor not found with id: " + requestMainTaskDto.getContractorId()));
            existingTask.setContractor(contractor);
        }

        // Update fields
        Optional.ofNullable(requestMainTaskDto.getTaskname()).ifPresent(existingTask::setTaskname);
        Optional.ofNullable(requestMainTaskDto.getStatus()).ifPresent(existingTask::setStatus);
        Optional.ofNullable(requestMainTaskDto.getStartDate()).ifPresent(existingTask::setStartDate);
        Optional.ofNullable(requestMainTaskDto.getEndDate()).ifPresent(existingTask::setEndDate);
        Optional.ofNullable(requestMainTaskDto.getDescription()).ifPresent(existingTask::setDescription);

        // Save the updated task
        MainTask updatedTask = mainTaskRepository.save(existingTask);

        // Convert to response DTO
        ResponseMainTaskDto responseMainTaskDto = new ResponseMainTaskDto();
        responseMainTaskDto.setId(updatedTask.getId());
        responseMainTaskDto.setTaskname(updatedTask.getTaskname());
        responseMainTaskDto.setStatus(updatedTask.getStatus());
        responseMainTaskDto.setStartDate(updatedTask.getStartDate());
        responseMainTaskDto.setEndDate(updatedTask.getEndDate());
        responseMainTaskDto.setDescription(updatedTask.getDescription());
        responseMainTaskDto.setContractor(contractorUtil.convertToResponseContractorDto(updatedTask.getContractor()));

        return responseMainTaskDto;
    }
}

