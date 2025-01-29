package com.civilink.civilink_project_management.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MainTask {

    @Id
    private Long id;
    private String name;
    private String status;  // Pending, In Progress, Completed
    private String startDate;
    private String endDate;

}
