package com.civilink.civilink_project_management.controllers;


import com.civilink.civilink_project_management.dtos.requests.RequestSubTaskDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseSubTaskDto;
import com.civilink.civilink_project_management.services.*;
import com.civilink.civilink_project_management.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/v1/sub")
public class SubTaskControllers {
    private SubTaskService subTaskService;

    public SubTaskControllers(SubTaskService subTaskService) {
        this.subTaskService = subTaskService;
    }

    @PostMapping("/create-subtask")
    public ResponseEntity<StandardResponse> createSubTask(@RequestBody RequestSubTaskDto requestSubTaskDto) {
        ResponseSubTaskDto response = subTaskService.createSubTask(requestSubTaskDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Subtask created successfully", response),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/getall")
    public ResponseEntity<StandardResponse>getAllSubTasks(){
        List<ResponseSubTaskDto> response = subTaskService.getAllSubTasks();
        return new ResponseEntity<>(
                new StandardResponse(200, "All subtasks retrieved successfully", response),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getSubTaskById(@PathVariable Long id) {
        ResponseSubTaskDto response = subTaskService.getSubTaskById(id);
        return new ResponseEntity<>(
                new StandardResponse(200, "Subtask retrieved successfully", response),
                HttpStatus.OK
        );
    }

//    @GetMapping("/main-task/{id}")
//    public ResponseEntity<StandardResponse> getSubTasksByMainTaskId(@PathVariable Long id) {
//        List<ResponseSubTaskDto> response = retrieveSubTasksService.getSubTasksByMainTaskId(id);
//        return new ResponseEntity<>(
//                new StandardResponse(200, "Subtasks for the specified main task retrieved successfully", response),
//                HttpStatus.OK
//        );
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StandardResponse> updateSubTask(@PathVariable Long id,
                                                           @RequestBody RequestSubTaskDto requestSubTaskDto) {
        ResponseSubTaskDto response = subTaskService.updateSubTask(id, requestSubTaskDto);
        return new ResponseEntity<>(
                new StandardResponse(200, "Sub task updated successfully", response),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteSubTask(@PathVariable Long id) {
        subTaskService.deleteSubTask(id);
        return new ResponseEntity<>(
                new StandardResponse(200, "Subtask deleted successfully", null),
                HttpStatus.OK
        );
    }


    @DeleteMapping("/delete-all/{mainTaskId}")
    public ResponseEntity<StandardResponse> deleteAllSubTasks(@PathVariable Long mainTaskId) {
        subTaskService.deleteAllSubTasksbyMaintask(mainTaskId);
        return new ResponseEntity<>(
                new StandardResponse(200, "All subtasks for the main task deleted successfully", null),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<StandardResponse> deleteAllSubTasks() {
        subTaskService.deleteAllSubTasks();
        return new ResponseEntity<>(
                new StandardResponse(200, "All subtasks deleted successfully", null),
                HttpStatus.OK
        );
    }

}


