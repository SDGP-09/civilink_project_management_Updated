package com.civilink.civilink_project_management.repositories;

import com.civilink.civilink_project_management.entities.MainTask;
import com.civilink.civilink_project_management.entities.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
    List<SubTask> findByMainTaskId(Long id);

    // Delete a subtask by its ID
    @Modifying
    @Query("DELETE FROM SubTask s WHERE s.id = :id")
    void deleteSubTaskById(Long id);

    // Delete all subtasks of a specific MainTask
    @Modifying
    @Query("DELETE FROM SubTask s WHERE s.mainTask.id = :mainTaskId")
    void deleteAllSubTasksBymaintask(Long mainTaskId);

    @Modifying
    @Query("DELETE FROM SubTask s")
    void deleteAllSubTasks();





}
