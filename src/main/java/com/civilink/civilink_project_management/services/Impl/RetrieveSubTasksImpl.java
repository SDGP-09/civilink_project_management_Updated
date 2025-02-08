package com.civilink.civilink_project_management.services.Impl;

import com.civilink.civilink_project_management.dtos.responses.ResponseSubTaskDto;
import com.civilink.civilink_project_management.entities.MainTask;
import com.civilink.civilink_project_management.entities.SubTask;
import com.civilink.civilink_project_management.exception.MainTaskNotFoundException;
import com.civilink.civilink_project_management.exception.SubTaskNotFoundException;
import com.civilink.civilink_project_management.repositories.MainTaskRepository;
import com.civilink.civilink_project_management.repositories.SubTaskRepository;
import com.civilink.civilink_project_management.services.RetrieveSubTasksService;
import com.civilink.civilink_project_management.util.SubtaskUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RetrieveSubTasksImpl implements RetrieveSubTasksService {
    private final SubTaskRepository subTaskRepository;
    private final MainTaskRepository mainTaskRepository;
    private final SubtaskUtil subtaskUtil;

    @Autowired
    public RetrieveSubTasksImpl(SubTaskRepository subTaskRepository,SubtaskUtil subtaskUtil,MainTaskRepository mainTaskRepository) {
        this.subTaskRepository = subTaskRepository;
        this.subtaskUtil = subtaskUtil;
        this.mainTaskRepository = mainTaskRepository;
    }

    //Retrieve All subtasks
    @Override
    public List<ResponseSubTaskDto> getAllSubTasks(){
        List<SubTask>subTasks = subTaskRepository.findAll();
        return subTasks.stream().map(subtaskUtil::convertToResponseSubTaskDto).collect(Collectors.toList());

    }

    //Retrieve a specific subtask using id
    @Override
    public ResponseSubTaskDto getSubTaskById(Long id){
        SubTask subTask = subTaskRepository.findById(id).orElse(null);
        if(subTask == null){
            throw new SubTaskNotFoundException("Sub Task not found with id: " + id);
        }
        return subtaskUtil.convertToResponseSubTaskDto(subTask);
    }

    // Retrieve subtasks for a specific main task
    @Override
    public List<ResponseSubTaskDto> getSubTasksByMainTaskId(Long id) {
        MainTask mainTask = mainTaskRepository.findById(id).orElse(null);
        if(mainTask == null){
            throw new MainTaskNotFoundException("Main Task not found with id: " + id);
        }
        List<SubTask> subTasks = subTaskRepository.findByMainTaskId(id);
        return subTasks.stream()
                .map(subtaskUtil::convertToResponseSubTaskDto)
                .collect(Collectors.toList());
    }





}
