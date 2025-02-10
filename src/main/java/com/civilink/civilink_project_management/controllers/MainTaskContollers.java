package com.civilink.civilink_project_management.controllers;

import com.civilink.civilink_project_management.dtos.requests.RequestMainTaskDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseMainTaskDto;
import com.civilink.civilink_project_management.services.CreateMainTaskService;
import com.civilink.civilink_project_management.services.DeleteMainTaskService;
import com.civilink.civilink_project_management.services.RetrieveMainTasksService;
import com.civilink.civilink_project_management.services.UpdateMainTaskService;
import com.civilink.civilink_project_management.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/main-tasks")

public class MainTaskContollers {
    private final CreateMainTaskService createMainTaskService;
    private final RetrieveMainTasksService retrieveMainTasksService;
    private final UpdateMainTaskService updateMainTaskService;
    private final DeleteMainTaskService deleteMainTaskService;

    public MainTaskContollers(CreateMainTaskService createMainTaskService,RetrieveMainTasksService retrieveMainTasksService,UpdateMainTaskService updateMainTaskService,DeleteMainTaskService deleteMainTaskService) {
        this.createMainTaskService = createMainTaskService;
        this.retrieveMainTasksService = retrieveMainTasksService;
        this.updateMainTaskService = updateMainTaskService;
        this.deleteMainTaskService = deleteMainTaskService;
    }

    @PostMapping("/create-main-task")
    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> createMainTask(@RequestBody RequestMainTaskDto requestMainTaskDto, Authentication authentication) {

        Jwt jwt = (Jwt) authentication.getPrincipal();
        List<String> groups = jwt.getClaimAsStringList("groups");

        if (groups == null || groups.isEmpty()) {
            throw new RuntimeException("User does not belong to any group.");
        }

        String userGroup = groups.get(0);

        ResponseMainTaskDto response = createMainTaskService.createMainTask(requestMainTaskDto,userGroup);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteMainTask(@PathVariable Long id) {
        deleteMainTaskService.deleteMainTask(id);
        return new ResponseEntity<>(
                new StandardResponse(200, "MainTask with ID " + id + " deleted successfully", null),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<StandardResponse> deleteAllMainTasks() {
        deleteMainTaskService.deleteAllMainTasks();
        return new ResponseEntity<>(
                new StandardResponse(200, "All MainTasks deleted successfully", null),
                HttpStatus.OK
        );
    }


}



