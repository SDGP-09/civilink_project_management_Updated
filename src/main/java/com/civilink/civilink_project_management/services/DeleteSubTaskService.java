package com.civilink.civilink_project_management.services;

public interface DeleteSubTaskService {
     void deleteAllSubTasks(Long mainTaskId);
     void deleteSubTask(Long subTaskId);

}
