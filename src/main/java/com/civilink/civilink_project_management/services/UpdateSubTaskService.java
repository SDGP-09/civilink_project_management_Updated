package com.civilink.civilink_project_management.services;

import com.civilink.civilink_project_management.dtos.requests.RequestSubTaskDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseSubTaskDto;

public interface UpdateSubTaskService {
    ResponseSubTaskDto updateSubTask(Long subTaskId, RequestSubTaskDto requestSubTaskDto);
}
