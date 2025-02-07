package com.civilink.civilink_project_management.controllers;

import com.civilink.civilink_project_management.dtos.requests.RequestMainTaskDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseMainTaskDto;
import com.civilink.civilink_project_management.services.CreateMainTaskService;
import com.civilink.civilink_project_management.services.RetrieveMainTasksService;
import com.civilink.civilink_project_management.services.UpdateMainTaskService;
import com.civilink.civilink_project_management.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/main-tasks")

public class MainTaskContollers {
    private final CreateMainTaskService createMainTaskService;
    private final RetrieveMainTasksService retrieveMainTasksService;
    private final UpdateMainTaskService updateMainTaskService;

    public MainTaskContollers(CreateMainTaskService createMainTaskService,RetrieveMainTasksService retrieveMainTasksService,UpdateMainTaskService updateMainTaskService) {
        this.createMainTaskService = createMainTaskService;
        this.retrieveMainTasksService = retrieveMainTasksService;
        this.updateMainTaskService = updateMainTaskService;
    }

    @PostMapping("/create-main-task")
    public ResponseEntity<StandardResponse> createMainTask(@RequestBody RequestMainTaskDto requestMainTaskDto) {
        ResponseMainTaskDto response = createMainTaskService.createMainTask(requestMainTaskDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Main task created successfully", response),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/getall")
    public ResponseEntity<StandardResponse> getAllMainTasks() {
        List<ResponseMainTaskDto> response = retrieveMainTasksService.getAllMainTasks();
        return new ResponseEntity<>(
                new StandardResponse(200, "All main tasks retrieved successfully", response),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getMainTaskById(@PathVariable Long id) {
        ResponseMainTaskDto response = retrieveMainTasksService.getMainTaskById(id);
        return new ResponseEntity<>(
                new StandardResponse(200, "Main task retrieved successfully", response),
                HttpStatus.OK
        );
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<StandardResponse> updateMainTask(@PathVariable Long id,
                                                           @RequestBody RequestMainTaskDto requestMainTaskDto) {
        ResponseMainTaskDto response = updateMainTaskService.updateMainTask(id, requestMainTaskDto);
        return new ResponseEntity<>(
                new StandardResponse(200, "Main task updated successfully", response),
                HttpStatus.OK
        );
    }


}



