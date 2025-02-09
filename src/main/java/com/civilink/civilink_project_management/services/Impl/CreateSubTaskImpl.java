package com.civilink.civilink_project_management.services.Impl;

import com.civilink.civilink_project_management.dtos.requests.RequestSubTaskDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseSubTaskDto;
import com.civilink.civilink_project_management.entities.MainTask;
import com.civilink.civilink_project_management.entities.SubTask;
import com.civilink.civilink_project_management.exception.MainTaskNotFoundException;
import com.civilink.civilink_project_management.repositories.MainTaskRepository;
import com.civilink.civilink_project_management.repositories.SubTaskRepository;
import com.civilink.civilink_project_management.services.CreateSubTaskService;
import com.civilink.civilink_project_management.util.SubtaskUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateSubTaskImpl implements CreateSubTaskService {

    private final SubTaskRepository subTaskRepository;
    private final MainTaskRepository mainTaskRepository;
    private final SubtaskUtil subtaskUtil;


    @Autowired
    public CreateSubTaskImpl(SubTaskRepository subTaskRepository, MainTaskRepository mainTaskRepository,SubtaskUtil subtaskUtil) {
        this.subTaskRepository = subTaskRepository;
        this.mainTaskRepository = mainTaskRepository;
        this.subtaskUtil = subtaskUtil;

    }

    @Override
    public ResponseSubTaskDto createSubTask(RequestSubTaskDto requestSubTaskDto) {

        // Fetch the main task
        MainTask mainTask = mainTaskRepository.findById(requestSubTaskDto.getMainTaskId()).orElse(null);
        if(mainTask == null){
            throw new MainTaskNotFoundException("This Main task id not found");
        }



        // Create the SubTask
        SubTask subTask = new SubTask();
        subTask.setTaskname(requestSubTaskDto.getTaskname());
        subTask.setStatus(requestSubTaskDto.getStatus());
        subTask.setStartDate(requestSubTaskDto.getStartDate());
        subTask.setEndDate(requestSubTaskDto.getEndDate());
        subTask.setDescription(requestSubTaskDto.getDescription());
        subTask.setMainTask(mainTask);



        // Save the SubTask to the database
        SubTask savedSubTask = subTaskRepository.save(subTask);
        return subtaskUtil.convertToResponseSubTaskDto(savedSubTask);





    }





}
