package com.civilink.civilink_project_management.repositories;

import com.civilink.civilink_project_management.entities.MainTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainTaskRepository extends JpaRepository<MainTask, Integer> {

}
