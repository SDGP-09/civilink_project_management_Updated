package com.civilink.civilink_project_management.services;

import com.civilink.civilink_project_management.dtos.requests.RequestMainTaskDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseMainTaskDto;

public interface UpdateMainTaskService {
    public ResponseMainTaskDto updateMainTask(Long taskId, RequestMainTaskDto requestMainTaskDto);
}
