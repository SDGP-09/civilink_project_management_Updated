package com.civilink.civilink_project_management.controllers;

import com.civilink.civilink_project_management.dtos.requests.RequestMainTaskDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseMainTaskDto;
import com.civilink.civilink_project_management.services.*;
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
@RequestMapping("/api/v1/main")
@CrossOrigin(origins = "*")

public class MainTaskContollers {
    private final MainTaskService mainTaskService;

    public MainTaskContollers(MainTaskService mainTaskService) {
        this.mainTaskService = mainTaskService;
    }


    @PostMapping("/create-main-task")
    @PreAuthorize("hasRole('ROLE_GENARAL_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> createMainTask(@RequestBody RequestMainTaskDto requestMainTaskDto, Authentication authentication) {

        Jwt jwt = (Jwt) authentication.getPrincipal();
        List<String> groups = jwt.getClaimAsStringList("group");

        if (groups == null || groups.isEmpty()) {
            throw new RuntimeException("User does not belong to any group.");
        }

        String userGroup = groups.get(0);

        ResponseMainTaskDto response = mainTaskService.createMainTask(requestMainTaskDto,userGroup);
        return new ResponseEntity<>(
                new StandardResponse(201, "Main task created successfully", response),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/get-all")
    public ResponseEntity<StandardResponse> getAllMainTasks(Authentication authentication) {

        Jwt jwt = (Jwt) authentication.getPrincipal();
        List<String> groups = jwt.getClaimAsStringList("group");

        if (groups == null || groups.isEmpty()) {
            throw new RuntimeException("User does not belong to any group.");
        }

        String userGroup = groups.get(0);

        List<ResponseMainTaskDto> response =  mainTaskService.getAllMainTasks(userGroup);
        return new ResponseEntity<>(
                new StandardResponse(200, "All main tasks retrieved successfully", response),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getMainTaskById(@PathVariable Long id, Authentication authentication) {
        Jwt jwt = (Jwt) authentication.getPrincipal();
        List<String> groups = jwt.getClaimAsStringList("groups");

        if (groups == null || groups.isEmpty()) {
            throw new RuntimeException("User does not belong to any group.");
        }

        String userGroup = groups.get(0);


        ResponseMainTaskDto response = mainTaskService.getMainTaskById(id,userGroup);
        return new ResponseEntity<>(
                new StandardResponse(200, "Main task retrieved successfully", response),
                HttpStatus.OK
        );
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<StandardResponse> updateMainTask(@PathVariable Long id,
                                                           @RequestBody RequestMainTaskDto requestMainTaskDto,Authentication authentication) {

        Jwt jwt = (Jwt) authentication.getPrincipal();
        List<String> groups = jwt.getClaimAsStringList("groups");

        if (groups == null || groups.isEmpty()) {
            throw new RuntimeException("User does not belong to any group.");
        }

        String userGroup = groups.get(0);

        ResponseMainTaskDto response = mainTaskService.updateMainTask(id, requestMainTaskDto,userGroup);
        return new ResponseEntity<>(
                new StandardResponse(200, "Main task updated successfully", response),
                HttpStatus.OK
        );
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteMainTask(@PathVariable Long id, Authentication authentication) {

        Jwt jwt = (Jwt) authentication.getPrincipal();
        List<String> groups = jwt.getClaimAsStringList("groups");

        if (groups == null || groups.isEmpty()) {
            throw new RuntimeException("User does not belong to any group.");
        }

        String userGroup = groups.get(0);

        mainTaskService.deleteMainTask(id,userGroup);
        return new ResponseEntity<>(
                new StandardResponse(200, "MainTask with ID " + id + " deleted successfully", null),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<StandardResponse> deleteAllMainTasks(Authentication authentication) {

        Jwt jwt = (Jwt) authentication.getPrincipal();
        List<String> groups = jwt.getClaimAsStringList("groups");

        if (groups == null || groups.isEmpty()) {
            throw new RuntimeException("User does not belong to any group.");
        }

        String userGroup = groups.get(0);

        mainTaskService.deleteAllMainTasks(userGroup);
        return new ResponseEntity<>(
                new StandardResponse(200, "All MainTasks deleted successfully", null),
                HttpStatus.OK
        );
    }


}



