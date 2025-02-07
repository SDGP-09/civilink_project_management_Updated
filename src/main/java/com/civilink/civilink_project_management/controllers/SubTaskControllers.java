package com.civilink.civilink_project_management.controllers;

import com.civilink.civilink_project_management.dtos.requests.RequestSubTaskDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseSubTaskDto;
import com.civilink.civilink_project_management.services.CreateSubTaskService;
import com.civilink.civilink_project_management.services.RetrieveSubTasksService;
import com.civilink.civilink_project_management.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/sub-tasks")
public class SubTaskControllers {

    private final CreateSubTaskService createSubTaskService;
    private final RetrieveSubTasksService retrieveSubTasksService;

    public SubTaskControllers(CreateSubTaskService createSubTaskService,RetrieveSubTasksService retrieveSubTasksService) {
        this.createSubTaskService = createSubTaskService;
        this.retrieveSubTasksService = retrieveSubTasksService;
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

}


