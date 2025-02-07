package com.civilink.civilink_project_management.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Contractor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BIGINT")
    private Long id;

    private String name;
    private String email;
    private String contact;

    // One contractor can have multiple main tasks
    @OneToMany(mappedBy = "contractor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MainTask> mainTasks;

    public Contractor() {
    }

    public Contractor(Long id, String name, String email, String contact, List<MainTask> mainTasks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.mainTasks = mainTasks;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<MainTask> getMainTasks() {
        return mainTasks;
    }

    public void setMainTasks(List<MainTask> mainTasks) {
        this.mainTasks = mainTasks;
    }
}
