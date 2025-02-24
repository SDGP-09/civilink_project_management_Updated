package com.civilink.civilink_project_management.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
public class MainTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String taskname;
    private String status;   // Pending, In Progress, Completed
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Column(nullable = false)
    private String groupId;


    public MainTask(Long id, String taskname, String status, LocalDate startDate, LocalDate endDate, String description, String groupId, List<SubTask> subtasks, Contractor contractor) {
        this.id = id;
        this.taskname = taskname;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.groupId = groupId;
        this.subtasks = subtasks;
//        this.contractor = contractor;
    }

    @OneToMany(mappedBy = "mainTask", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<SubTask> subtasks;


    // Many tasks belong to one contractor
//    @ManyToOne
//    @JoinColumn(name = "contractor_id", nullable = false)
//    private Contractor contractor;


    public MainTask() {
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

//    public Contractor getContractor() {
//        return contractor;
//    }
//
//    public void setContractor(Contractor contractor) {
//        this.contractor = contractor;
//    }
}
