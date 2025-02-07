package com.civilink.civilink_project_management.services;

import com.civilink.civilink_project_management.dtos.responses.ResponseMainTaskDto;
import java.util.List;


public interface RetrieveMainTasksService {
     List<ResponseMainTaskDto> getAllMainTasks();
     ResponseMainTaskDto getMainTaskById(Long id);
}
