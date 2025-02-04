package com.civilink.civilink_project_management.util;

import com.civilink.civilink_project_management.dtos.responses.ResponseSubTaskDto;
import com.civilink.civilink_project_management.entities.SubTask;
import org.springframework.stereotype.Component;

@Component
public class SubtaskUtil {

    public ResponseSubTaskDto convertToResponseSubTaskDto(SubTask subTask) {

        ResponseSubTaskDto responseSubTaskDto = new ResponseSubTaskDto();
        responseSubTaskDto.setId(subTask.getId());
        responseSubTaskDto.setTaskname(subTask.getTaskname());
        responseSubTaskDto.setStatus(subTask.getStatus());
        responseSubTaskDto.setStartDate(subTask.getStartDate());
        responseSubTaskDto.setEndDate(subTask.getEndDate());
        responseSubTaskDto.setDescription(subTask.getDescription());
        responseSubTaskDto.setMainTaskId(subTask.getMainTask().getId());

        return responseSubTaskDto;
    }
}
