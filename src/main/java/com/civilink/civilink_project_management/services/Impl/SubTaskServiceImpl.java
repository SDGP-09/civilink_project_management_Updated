package com.civilink.civilink_project_management.services.Impl;

import com.civilink.civilink_project_management.dtos.requests.RequestSubTaskDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseContractorDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseSubTaskDto;
import com.civilink.civilink_project_management.entities.Contractor;
import com.civilink.civilink_project_management.entities.MainTask;
import com.civilink.civilink_project_management.entities.SubTask;
import com.civilink.civilink_project_management.repositories.ContractorRepository;
import com.civilink.civilink_project_management.repositories.MainTaskRepository;
import com.civilink.civilink_project_management.repositories.SubTaskRepository;
import com.civilink.civilink_project_management.services.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubTaskServiceImpl implements SubTaskService {

    private final SubTaskRepository subTaskRepository;
    private final MainTaskRepository mainTaskRepository;
    private final ContractorRepository contractorRepository;

    @Autowired
    public SubTaskServiceImpl(SubTaskRepository subTaskRepository, MainTaskRepository mainTaskRepository, ContractorRepository contractorRepository) {
        this.subTaskRepository = subTaskRepository;
        this.mainTaskRepository = mainTaskRepository;
        this.contractorRepository = contractorRepository;
    }

    @Override
    public ResponseSubTaskDto createSubTask(RequestSubTaskDto requestSubTaskDto) {
        // Fetch the main task and contractor
        MainTask mainTask = mainTaskRepository.findById(requestSubTaskDto.getMainTaskId())
                .orElseThrow(() -> new RuntimeException("Main task not found"));

        Contractor contractor = contractorRepository.findById(requestSubTaskDto.getContractorId())
                .orElseThrow(() -> new RuntimeException("Contractor not found"));

        // Create the SubTask
        SubTask subTask = new SubTask();
        subTask.setTaskname(requestSubTaskDto.getTaskname());
        subTask.setStatus(requestSubTaskDto.getStatus());
        subTask.setStartDate(requestSubTaskDto.getStartDate());
        subTask.setEndDate(requestSubTaskDto.getEndDate());
        subTask.setDescription(requestSubTaskDto.getDescription());
        subTask.setMainTask(mainTask);
        subTask.setContractor(contractor);


        // Save the SubTask to the database
        SubTask savedSubTask = subTaskRepository.save(subTask);


        // Create ResponseContractorDto
        ResponseContractorDto contractorDto = new ResponseContractorDto();
        contractorDto.setId(contractor.getId());
        contractorDto.setName(contractor.getName());
        contractorDto.setEmail(contractor.getEmail());
        contractorDto.setContact(contractor.getContact());


        //  return the response DTO
        ResponseSubTaskDto responseSubTaskDto = new ResponseSubTaskDto();
        responseSubTaskDto.setId(savedSubTask.getId());
        responseSubTaskDto.setTaskname(savedSubTask.getTaskname());
        responseSubTaskDto.setStatus(savedSubTask.getStatus());
        responseSubTaskDto.setStartDate(savedSubTask.getStartDate());
        responseSubTaskDto.setEndDate(savedSubTask.getEndDate());
        responseSubTaskDto.setDescription(savedSubTask.getDescription());
        responseSubTaskDto.setMainTaskId(savedSubTask.getMainTask().getId()); // Reference to the main task
        responseSubTaskDto.setContractor(contractorDto); // Include the contractor details

        return responseSubTaskDto;


    }





}
