package com.civilink.civilink_project_management.services;

import com.civilink.civilink_project_management.dtos.requests.RequestMainTaskDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseMainTaskDto;

import java.util.List;

public interface MainTaskService {
    ResponseMainTaskDto createMainTask(RequestMainTaskDto requestMainTaskDto);

}
