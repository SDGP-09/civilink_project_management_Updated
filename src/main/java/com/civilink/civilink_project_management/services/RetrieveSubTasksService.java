package com.civilink.civilink_project_management.services;

import com.civilink.civilink_project_management.dtos.responses.ResponseSubTaskDto;
import java.util.List;
import java.util.UUID;

public interface RetrieveSubTasksService {
    List<ResponseSubTaskDto> getAllSubTasks();
    ResponseSubTaskDto getSubTaskById(Long id);
}
