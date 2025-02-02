package com.civilink.civilink_project_management.dtos.responses;


public class ResponseSubTaskDto {
    private Integer id;
    private String taskname;
    private String status;
    private String startDate;
    private String endDate;
    private String description;
    private Integer mainTaskId;  // Reference to the MainTask ID
    private ResponseContractorDto contractor;  // Full contractor details

    public ResponseSubTaskDto() {
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMainTaskId() {
        return mainTaskId;
    }

    public void setMainTaskId(Integer mainTaskId) {
        this.mainTaskId = mainTaskId;
    }

    public ResponseContractorDto getContractor() {
        return contractor;
    }

    public void setContractor(ResponseContractorDto contractor) {
        this.contractor = contractor;
    }
}
