package com.civilink.civilink_project_management.dtos.requests;
import java.time.LocalDate;
import java.util.List;

public class RequestMainTaskDto {

    private String taskname;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private List<Integer> subtaskIds;  // Reference to SubTask IDs
    private Integer contractorId;     // Reference to Contractor ID


    public RequestMainTaskDto(String taskname,String status,LocalDate startDate,LocalDate endDate,String description,List<Integer>subtaskIds,Integer contractorId) {
        this.taskname = taskname;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.subtaskIds = subtaskIds;
        this.contractorId = contractorId;
    }

    public RequestMainTaskDto() {
    }

    public String getTaskname() {return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getStatus() {return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getStartDate() {return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {return endDate;
    }

    public void setEndDate( LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getSubtaskIds() {return subtaskIds;
    }

    public void setSubtaskIds(List<Integer> subtaskIds) {
        this.subtaskIds = subtaskIds;
    }

    public Integer getContractorId() {return contractorId;
    }

    public void setContractorId(Integer contractorId) {
        this.contractorId = contractorId;
    }
}
