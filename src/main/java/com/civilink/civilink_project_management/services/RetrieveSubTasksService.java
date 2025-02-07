package com.civilink.civilink_project_management.services;

import com.civilink.civilink_project_management.dtos.responses.ResponseSubTaskDto;
import java.util.List;


public interface RetrieveSubTasksService {
    List<ResponseSubTaskDto> getAllSubTasks();
    ResponseSubTaskDto getSubTaskById(Long id);
}
