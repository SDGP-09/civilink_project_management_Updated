package com.civilink.civilink_project_management.dtos.responses;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class OngoingProjectsDto {
    private Long id;
    private String name;
    private String status;
    private String description;
    private String timeline;
    private String image;

    public OngoingProjectsDto() {
    }

    public OngoingProjectsDto(Long id, String name, String status, String description, LocalDate startDate, LocalDate endDate, String image) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.description = description;
        this.timeline = calculateTimeline(startDate, endDate);
        this.image = image;
    }

    private String calculateTimeline(LocalDate startDate, LocalDate endDate) {
        if (startDate != null && endDate != null) {
            long daysElapsed = ChronoUnit.DAYS.between(startDate, LocalDate.now());
            long totalDays = ChronoUnit.DAYS.between(startDate, endDate);
            return daysElapsed + " days elapsed / " + totalDays + " days total";
        }
        return "Unknown timeline";
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeline() {
        return timeline;
    }

    public void setTimeline(String timeline) {
        this.timeline = timeline;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
