package com.civilink.civilink_project_management.services.Impl;

import com.civilink.civilink_project_management.dtos.requests.RequestMainTaskDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseMainTaskDto;
import com.civilink.civilink_project_management.entities.Contractor;
import com.civilink.civilink_project_management.entities.MainTask;
import com.civilink.civilink_project_management.exception.ContractorNotFoundException;
import com.civilink.civilink_project_management.repositories.ContractorRepository;
import com.civilink.civilink_project_management.repositories.MainTaskRepository;
import com.civilink.civilink_project_management.services.CreateMainTaskService;
import com.civilink.civilink_project_management.util.ContractorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class CreateMainTaskImpl implements CreateMainTaskService {
    private final MainTaskRepository mainTaskRepository;
    private final ContractorRepository contractorRepository;
    private final ContractorUtil contractorUtil;


    @Autowired
    public CreateMainTaskImpl(MainTaskRepository mainTaskRepository, ContractorRepository contractorRepository, ContractorUtil contractorUtil) {
        this.mainTaskRepository = mainTaskRepository;
        this.contractorRepository = contractorRepository;
        this.contractorUtil = contractorUtil;

    }

    @Override
    public ResponseMainTaskDto createMainTask(RequestMainTaskDto requestMainTaskDto) {

        // Retrieve Contractor
        Contractor contractor = contractorRepository.findById(requestMainTaskDto.getContractorId()).orElse(null);
        if (contractor == null){
            throw new ContractorNotFoundException("Contractor not found with id: " + requestMainTaskDto.getContractorId());
        }


        //create main task
        MainTask mainTask = new MainTask();
        mainTask.setTaskname(requestMainTaskDto.getTaskname());
        mainTask.setStatus(requestMainTaskDto.getStatus());
        mainTask.setStartDate(requestMainTaskDto.getStartDate());
        mainTask.setEndDate(requestMainTaskDto.getEndDate());
        mainTask.setDescription(requestMainTaskDto.getDescription());
        mainTask.setContractor(contractor);

        // Save to the database
        MainTask savedmainTask = mainTaskRepository.save(mainTask);


        //convert to responsedto
        ResponseMainTaskDto responseMainTaskDto = new ResponseMainTaskDto();
        responseMainTaskDto.setId(savedmainTask.getId());
        responseMainTaskDto.setTaskname(savedmainTask.getTaskname());
        responseMainTaskDto.setStatus(savedmainTask.getStatus());
        responseMainTaskDto.setStartDate(savedmainTask.getStartDate());
        responseMainTaskDto.setEndDate(savedmainTask.getEndDate());
        responseMainTaskDto.setDescription(savedmainTask.getDescription());
        responseMainTaskDto.setContractor(contractorUtil.convertToResponseContractorDto(mainTask.getContractor()));


        return responseMainTaskDto;
    }


}












