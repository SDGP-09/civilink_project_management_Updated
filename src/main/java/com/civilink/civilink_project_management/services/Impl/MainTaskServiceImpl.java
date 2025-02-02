package com.civilink.civilink_project_management.services.Impl;

import com.civilink.civilink_project_management.dtos.requests.RequestMainTaskDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseContractorDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseMainTaskDto;
import com.civilink.civilink_project_management.entities.Contractor;
import com.civilink.civilink_project_management.entities.MainTask;
import com.civilink.civilink_project_management.repositories.ContractorRepository;
import com.civilink.civilink_project_management.repositories.MainTaskRepository;
import com.civilink.civilink_project_management.services.MainTaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainTaskServiceImpl implements MainTaskService {
    private final MainTaskRepository mainTaskRepository;
    private final ContractorRepository contractorRepository;

    @Autowired
    public MainTaskServiceImpl(MainTaskRepository mainTaskRepository, ContractorRepository contractorRepository) {
        this.mainTaskRepository = mainTaskRepository;
        this.contractorRepository = contractorRepository;
    }

    @Override
    public ResponseMainTaskDto createMainTask(RequestMainTaskDto requestMainTaskDto) {

        // Retrieve Contractor
        Contractor contractor = contractorRepository.findById(requestMainTaskDto.getContractorId())
                .orElseThrow(() -> new RuntimeException("Contractor not found with id: " + requestMainTaskDto.getContractorId()));


        //create main task
        MainTask mainTask = new MainTask();
        mainTask.setTaskname(requestMainTaskDto.getTaskname());
        mainTask.setStatus(requestMainTaskDto.getStatus());
        mainTask.setStartDate(requestMainTaskDto.getStartDate());
        mainTask.setEndDate(requestMainTaskDto.getEndDate());
        mainTask.setDescription(requestMainTaskDto.getDescription());
        mainTask.setContractor(contractor);

        // Save to the database
        MainTask savedMainTask = mainTaskRepository.save(mainTask);

        // Create and return  Response DTO
        ResponseMainTaskDto responseMainTaskDto = new ResponseMainTaskDto();
        responseMainTaskDto.setId(savedMainTask.getId());
        responseMainTaskDto.setTaskname(savedMainTask.getTaskname());
        responseMainTaskDto.setStatus(savedMainTask.getStatus());
        responseMainTaskDto.setStartDate(savedMainTask.getStartDate());
        responseMainTaskDto.setEndDate(savedMainTask.getEndDate());
        responseMainTaskDto.setDescription(savedMainTask.getDescription());
        responseMainTaskDto.setContractor(new ResponseContractorDto(contractor.getId(), contractor.getName(), contractor.getEmail(), contractor.getContact()));

        return responseMainTaskDto;
    }


}







