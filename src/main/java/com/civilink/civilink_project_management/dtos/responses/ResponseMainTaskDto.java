package com.civilink.civilink_project_management.dtos.responses;
import java.time.LocalDate;
import java.util.List;

public class ResponseMainTaskDto {
    private Integer id;
    private String taskname;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private List<ResponseSubTaskDto> subtasks;
    private ResponseContractorDto contractor;

    public ResponseMainTaskDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setStartDate(LocalDate startDate) {
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

    public List<ResponseSubTaskDto> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<ResponseSubTaskDto> subtasks) {
        this.subtasks = subtasks;
    }

    public ResponseContractorDto getContractor() {
        return contractor;
    }

    public void setContractor(ResponseContractorDto contractor) {
        this.contractor = contractor;
    }
}
