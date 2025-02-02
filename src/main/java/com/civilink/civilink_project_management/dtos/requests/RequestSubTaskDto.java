package com.civilink.civilink_project_management.dtos.requests;

public class RequestSubTaskDto {
    private String taskname;
    private String status;
    private String startDate;
    private String endDate;
    private String description;
    private Integer mainTaskId;  // Reference to the MainTask ID
    private Integer contractorId;  // Reference to the Contractor ID

    public RequestSubTaskDto(String taskname,String status, String startDate, String endDate, String description, Integer maintaskId, Integer contractorId) {
        this.taskname = taskname;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.mainTaskId = maintaskId;
        this.contractorId = contractorId;
    }

    public RequestSubTaskDto() {
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

    public Integer getContractorId() {
        return contractorId;
    }

    public void setContractorId(Integer contractorId) {
        this.contractorId = contractorId;
    }
}
