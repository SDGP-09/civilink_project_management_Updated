package com.civilink.civilink_project_management.services.Impl;

import com.civilink.civilink_project_management.dtos.requests.RequestMainTaskDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseMainTaskDto;
import com.civilink.civilink_project_management.entities.Contractor;
import com.civilink.civilink_project_management.entities.MainTask;
import com.civilink.civilink_project_management.repositories.ContractorRepository;
import com.civilink.civilink_project_management.repositories.MainTaskRepository;
import com.civilink.civilink_project_management.services.CreateMainTaskService;
import com.civilink.civilink_project_management.util.MaintaskUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateMainTaskImpl implements CreateMainTaskService {
    private final MainTaskRepository mainTaskRepository;
    private final ContractorRepository contractorRepository;
    private final MaintaskUtil maintaskUtil;

    @Autowired
    public CreateMainTaskImpl(MainTaskRepository mainTaskRepository, ContractorRepository contractorRepository, MaintaskUtil maintaskUtil) {
        this.mainTaskRepository = mainTaskRepository;
        this.contractorRepository = contractorRepository;
        this.maintaskUtil = maintaskUtil;
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

        return maintaskUtil.convertToResponseMainTaskDto(savedMainTask);



    }




}







