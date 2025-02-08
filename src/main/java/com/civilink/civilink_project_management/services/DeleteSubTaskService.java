package com.civilink.civilink_project_management.services;

public interface DeleteSubTaskService {
     void deleteAllSubTasksbyMaintask(Long mainTaskId);
     void deleteSubTask(Long subTaskId);
     void deleteAllSubTasks();


}
