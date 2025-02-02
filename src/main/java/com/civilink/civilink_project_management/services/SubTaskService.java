package com.civilink.civilink_project_management.services;

import com.civilink.civilink_project_management.dtos.requests.RequestSubTaskDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseSubTaskDto;

public interface SubTaskService {
    ResponseSubTaskDto createSubTask(RequestSubTaskDto request);
}
