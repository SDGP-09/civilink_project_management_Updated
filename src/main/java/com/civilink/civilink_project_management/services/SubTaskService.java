package com.civilink.civilink_project_management.services;

import com.civilink.civilink_project_management.dtos.requests.RequestSubTaskDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseSubTaskDto;

import java.util.List;

public interface SubTaskService {
    ResponseSubTaskDto createSubTask(RequestSubTaskDto request);
    List<ResponseSubTaskDto> getAllSubTasks();
    ResponseSubTaskDto getSubTaskById(Long id);
    //List<ResponseSubTaskDto> getSubTasksByMainTaskId(Long id);
    ResponseSubTaskDto updateSubTask(Long subTaskId, RequestSubTaskDto requestSubTaskDto);
    void deleteAllSubTasksbyMaintask(Long mainTaskId);
    void deleteSubTask(Long subTaskId);
    void deleteAllSubTasks();
}
