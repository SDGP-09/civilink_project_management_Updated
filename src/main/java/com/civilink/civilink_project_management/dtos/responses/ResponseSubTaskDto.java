package com.civilink.civilink_project_management.dtos.responses;

import java.time.LocalDate;


public class ResponseSubTaskDto {
    private Long id;
    private String taskname;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private Long mainTaskId;  // Reference to the MainTask ID


    public ResponseSubTaskDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate( LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getMainTaskId() {
        return mainTaskId;
    }

    public void setMainTaskId(Long mainTaskId) {
        this.mainTaskId = mainTaskId;
    }


}
