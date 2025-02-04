package com.civilink.civilink_project_management.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
public class MainTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String taskname;
    private String status;  // Pending, In Progress, Completed
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;

    @OneToMany(mappedBy = "mainTask", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<SubTask> subtasks;

    @ManyToOne
    @JoinColumn(name = "contractor_id", nullable = false)
    private Contractor contractor;


    public MainTask() {
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

    public List<SubTask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<SubTask> subtasks) {
        this.subtasks = subtasks;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }
}
