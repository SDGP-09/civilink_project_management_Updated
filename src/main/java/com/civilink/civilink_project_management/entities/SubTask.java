package com.civilink.civilink_project_management.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String taskname;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;

    @ManyToOne
    @JoinColumn(name = "main_task_id", nullable = false)
    private MainTask mainTask;


    public SubTask() {
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

    public MainTask getMainTask() {
        return mainTask;
    }

    public void setMainTask(MainTask mainTask) {
        this.mainTask = mainTask;
    }


}
