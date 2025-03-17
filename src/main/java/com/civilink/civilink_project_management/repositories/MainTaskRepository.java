package com.civilink.civilink_project_management.repositories;

import com.civilink.civilink_project_management.entities.MainTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainTaskRepository extends JpaRepository<MainTask, Long> {

    @Query(value = "SELECT * FROM MainTask WHERE groupId = ?1", nativeQuery = true)
    List<MainTask> findAllByGroupId(String groupId);


    @Query("SELECT m FROM MainTask m WHERE m.groupId = ?1 OR m.contractorId = ?1")
    List<MainTask> findAllMainTasks(String groupId);


    @Query("SELECT m FROM MainTask m WHERE m.status = 'Completed' AND m.groupId = :groupId")
    List<MainTask> findAllCompletedMainTasks(String groupId);

    @Query("SELECT m FROM MainTask m WHERE m.status = 'Ongoing' AND m.groupId = :groupId")
    List<MainTask> findAllOngoingMainTasks(String groupId);





}
