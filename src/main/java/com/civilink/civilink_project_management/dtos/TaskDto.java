package com.civilink.civilink_project_management.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private Long id;
    private String name;
    private String status;  // Pending, In Progress, Completed
    private String startDate;
    private String endDate;


}
