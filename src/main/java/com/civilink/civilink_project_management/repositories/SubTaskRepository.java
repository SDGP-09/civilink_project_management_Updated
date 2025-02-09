package com.civilink.civilink_project_management.repositories;

import com.civilink.civilink_project_management.entities.MainTask;
import com.civilink.civilink_project_management.entities.SubTask;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
    void deleteAllByMainTask(MainTask mainTask);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM sub_task WHERE main_task_id = ?1", nativeQuery = true)
    void deleteSubTaskByMainTaskId(Long Id);



    // Delete all subtasks of a specific MainTask
    @Modifying
    @Query("DELETE FROM SubTask s WHERE s.mainTask.id = :mainTaskId")
    void deleteAllSubTasksBymaintask(Long mainTaskId);

    @Modifying
    @Query("DELETE FROM SubTask s")
    void deleteAllSubTasks();

    List<SubTask> findAllByMainTaskId(Long id);


}
