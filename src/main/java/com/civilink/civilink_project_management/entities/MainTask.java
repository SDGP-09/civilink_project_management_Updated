package com.civilink.civilink_project_management.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
public class MainTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String taskName;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;

    @Column(name = "groupId", nullable = false)
    private String groupId;

    @Column(nullable = false)
    private boolean expanded;

    @OneToMany(mappedBy = "mainTask", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<SubTask> subtasks;

    @Column(name = "contractorId", nullable = false)  // Store only contractor's ID
    private String contractorId;



    public MainTask(Long id, String taskName, String status, LocalDate startDate, LocalDate endDate, String description, String groupId, List<SubTask> subtasks, boolean expanded, String contractorId ) {
        this.id = id;
        this.taskName = taskName;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.groupId = groupId;
        this.subtasks = subtasks;
        this.expanded = expanded;
        this.contractorId = contractorId;
    }




    public MainTask() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskname) {
        this.taskName = taskname;
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

    public List<SubTask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<SubTask> subtasks) {
        this.subtasks = subtasks;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }


    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getContractorId() {
        return contractorId;
    }

    public void setContractorId(String contractorId) {
        this.contractorId = contractorId;
    }


}


