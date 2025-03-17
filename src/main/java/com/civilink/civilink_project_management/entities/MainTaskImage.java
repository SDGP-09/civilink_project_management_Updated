package com.civilink.civilink_project_management.entities;

import jakarta.persistence.*;

@Entity
public class MainTaskImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "mainTask_id", nullable = false)
    private MainTask mainTask;


    public MainTaskImage() {
    }

    public MainTaskImage(String imageUrl, MainTask mainTask) {
        this.imageUrl = imageUrl;
        this.mainTask = mainTask;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public MainTask getMainTask() {
        return mainTask;
    }

    public void setMainTask(MainTask mainTask) {
        this.mainTask = mainTask;
    }
}

