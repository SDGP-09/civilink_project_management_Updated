package com.civilink.civilink_project_management.dtos.responses;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CompletedProjectsDto {
    private Long id;
    private String title;
    private String description;
    private String status;
    private String image;
    private String duration;
    private String completedDate;
    private String visibility;

    public CompletedProjectsDto() {
    }

    public CompletedProjectsDto(Long id, String title, String description, String status, String image, LocalDate startDate, LocalDate endDate, LocalDate completedDate, boolean visibility) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.image = image;
        this.duration = calculateDuration(startDate, endDate);
        this.completedDate = completedDate != null ? completedDate.toString() : null;
        this.visibility = visibility ? "Public" : "Private";
    }

    private String calculateDuration(LocalDate startDate, LocalDate endDate) {
        if (startDate != null && endDate != null) {
            long days = ChronoUnit.DAYS.between(startDate, endDate);
            return days + " days";
        }
        return "Unknown";
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}

