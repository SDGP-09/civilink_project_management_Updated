package com.civilink.civilink_project_management.repositories;

import com.civilink.civilink_project_management.entities.MainTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainTaskRepository extends JpaRepository<MainTask, Long> {

    @Query(value = "SELECT * FROM main_task WHERE group_id = ?1", nativeQuery = true)
    List<MainTask> findAllByGroupId(String groupId);
}
