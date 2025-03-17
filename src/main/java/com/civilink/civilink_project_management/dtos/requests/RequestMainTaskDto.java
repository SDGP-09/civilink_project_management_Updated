package com.civilink.civilink_project_management.dtos.requests;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;


public class RequestMainTaskDto {

    private String taskname;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private boolean expanded;
    private String contractorId;
    private List<MultipartFile> images;



    public RequestMainTaskDto(String taskname,String status,LocalDate startDate,LocalDate endDate,String description, boolean expanded, String contractorId,List<MultipartFile>images) {
        this.taskname = taskname;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.expanded = expanded;
        this.contractorId = contractorId;
        this.images = images;


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

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getContractorId() {return contractorId;
    }

    public void setContractorId(String contractorId) {this.contractorId = contractorId;
    }

    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }
}
