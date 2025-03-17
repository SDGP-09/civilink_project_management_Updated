package com.civilink.civilink_project_management.services;

import com.civilink.civilink_project_management.dtos.requests.RequestMainTaskDto;
import com.civilink.civilink_project_management.dtos.responses.CompletedProjectsDto;
import com.civilink.civilink_project_management.dtos.responses.OngoingProjectsDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseMainTaskDto;
import com.civilink.civilink_project_management.entities.MainTask;

import java.util.List;

public interface MainTaskService {
    ResponseMainTaskDto createMainTask(RequestMainTaskDto requestMainTaskDto, String groupId);
    List<ResponseMainTaskDto> getAllMainTasks(String group);
    ResponseMainTaskDto getMainTaskById(Long id, String groupId);
    ResponseMainTaskDto updateMainTask(Long taskId, RequestMainTaskDto requestMainTaskDto, String groupId);
    void deleteMainTask(Long id,String groupId);
    void deleteAllMainTasks(String groupId);
    List<CompletedProjectsDto> getCompletedMainTasks(String groupId);
    List<OngoingProjectsDto> getOngoingMainTasks(String groupId);

}

