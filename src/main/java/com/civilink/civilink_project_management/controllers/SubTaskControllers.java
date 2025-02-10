package com.civilink.civilink_project_management.controllers;


import com.civilink.civilink_project_management.dtos.requests.RequestSubTaskDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseSubTaskDto;
import com.civilink.civilink_project_management.services.CreateSubTaskService;
import com.civilink.civilink_project_management.services.DeleteSubTaskService;
import com.civilink.civilink_project_management.services.RetrieveSubTasksService;
import com.civilink.civilink_project_management.services.UpdateSubTaskService;
import com.civilink.civilink_project_management.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/" +
        "")
public class SubTaskControllers {

    private final CreateSubTaskService createSubTaskService;
    private final RetrieveSubTasksService retrieveSubTasksService;
    private final UpdateSubTaskService updateSubTaskService;
    private final DeleteSubTaskService deleteSubTaskService;

    public SubTaskControllers(CreateSubTaskService createSubTaskService,RetrieveSubTasksService retrieveSubTasksService, UpdateSubTaskService updateSubTaskService, DeleteSubTaskService deleteSubTaskService) {
        this.createSubTaskService = createSubTaskService;
        this.retrieveSubTasksService = retrieveSubTasksService;
        this.updateSubTaskService = updateSubTaskService;
        this.deleteSubTaskService = deleteSubTaskService;
    }

    @PostMapping("/create-subtask")
    public ResponseEntity<StandardResponse> createSubTask(@RequestBody RequestSubTaskDto requestSubTaskDto) {
        ResponseSubTaskDto response = createSubTaskService.createSubTask(requestSubTaskDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Subtask created successfully", response),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/getall")
    public ResponseEntity<StandardResponse>getAllSubTasks(){
        List<ResponseSubTaskDto> response = retrieveSubTasksService.getAllSubTasks();
        return new ResponseEntity<>(
                new StandardResponse(200, "All subtasks retrieved successfully", response),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getSubTaskById(@PathVariable Long id) {
        ResponseSubTaskDto response = retrieveSubTasksService.getSubTaskById(id);
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
        ResponseSubTaskDto response = updateSubTaskService.updateSubTask(id, requestSubTaskDto);
        return new ResponseEntity<>(
                new StandardResponse(200, "Sub task updated successfully", response),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteSubTask(@PathVariable Long id) {
        deleteSubTaskService.deleteSubTask(id);
        return new ResponseEntity<>(
                new StandardResponse(200, "Subtask deleted successfully", null),
                HttpStatus.OK
        );
    }


    @DeleteMapping("/delete-all/{mainTaskId}")
    public ResponseEntity<StandardResponse> deleteAllSubTasks(@PathVariable Long mainTaskId) {
        deleteSubTaskService.deleteAllSubTasks(mainTaskId);
        return new ResponseEntity<>(
                new StandardResponse(200, "All subtasks for the main task deleted successfully", null),
                HttpStatus.OK
        );
    }

}


