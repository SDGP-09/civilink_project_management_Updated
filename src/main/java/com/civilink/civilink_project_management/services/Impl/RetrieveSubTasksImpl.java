package com.civilink.civilink_project_management.services.Impl;

import com.civilink.civilink_project_management.dtos.responses.ResponseSubTaskDto;
import com.civilink.civilink_project_management.entities.SubTask;
import com.civilink.civilink_project_management.repositories.SubTaskRepository;
import com.civilink.civilink_project_management.services.RetrieveSubTasksService;
import com.civilink.civilink_project_management.util.SubtaskUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetrieveSubTasksImpl implements RetrieveSubTasksService {
    private final SubTaskRepository subTaskRepository;
    private final SubtaskUtil subtaskUtil;

    @Autowired
    public RetrieveSubTasksImpl(SubTaskRepository subTaskRepository,SubtaskUtil subtaskUtil) {
        this.subTaskRepository = subTaskRepository;
        this.subtaskUtil = subtaskUtil;
    }

    //Retrieve All subtasks
    @Override
    public List<ResponseSubTaskDto> getAllSubTasks(){
        List<SubTask>subTasks = subTaskRepository.findAll();
        return subTasks.stream().map(subtaskUtil::convertToResponseSubTaskDto).collect(Collectors.toList());

    }

    //Retrieve a specific subtask using Id
    @Override
    public ResponseSubTaskDto getSubTaskById(Integer id){
        SubTask subTask = subTaskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sub Task not found with id: " + id));
        return subtaskUtil.convertToResponseSubTaskDto(subTask);
    }






}
