package com.civilink.civilink_project_management.services.Impl;


import com.civilink.civilink_project_management.dtos.requests.RequestSubTaskDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseSubTaskDto;
import com.civilink.civilink_project_management.entities.MainTask;
import com.civilink.civilink_project_management.entities.SubTask;
import com.civilink.civilink_project_management.exception.MainTaskNotFoundException;
import com.civilink.civilink_project_management.exception.SubTaskNotFoundException;
import com.civilink.civilink_project_management.repositories.MainTaskRepository;
import com.civilink.civilink_project_management.repositories.SubTaskRepository;
import com.civilink.civilink_project_management.services.SubTaskService;
import com.civilink.civilink_project_management.util.SubtaskUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubTaskServiceImpl implements SubTaskService {

    private final SubTaskRepository subTaskRepository;
    private final MainTaskRepository mainTaskRepository;
    private final SubtaskUtil subtaskUtil;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public SubTaskServiceImpl(SubTaskRepository subTaskRepository, MainTaskRepository mainTaskRepository,SubtaskUtil subtaskUtil) {
        this.subTaskRepository = subTaskRepository;
        this.mainTaskRepository = mainTaskRepository;
        this.subtaskUtil = subtaskUtil;

    }

    @Override
    public ResponseSubTaskDto createSubTask(RequestSubTaskDto requestSubTaskDto) {

        // Fetch the main task
        MainTask mainTask = mainTaskRepository.findById(requestSubTaskDto.getMainTaskId()).orElse(null);
        if(mainTask == null){
            throw new MainTaskNotFoundException("This Main task id not found");
        }

        // Create the SubTask
        SubTask subTask = new SubTask();
        subTask.setTaskname(requestSubTaskDto.getTaskname());
        subTask.setStatus(requestSubTaskDto.getStatus());
        subTask.setStartDate(requestSubTaskDto.getStartDate());
        subTask.setEndDate(requestSubTaskDto.getEndDate());
        subTask.setDescription(requestSubTaskDto.getDescription());
        subTask.setMainTask(mainTask);

        // Save the SubTask to the database
        SubTask savedSubTask = subTaskRepository.save(subTask);
        return subtaskUtil.convertToResponseSubTaskDto(savedSubTask);
    }





    //Retrieve All subtasks
    @Override
    public List<ResponseSubTaskDto> getAllSubTasks(){
        List<SubTask>subTasks = subTaskRepository.findAll();
        return subTasks.stream().map(subtaskUtil::convertToResponseSubTaskDto).collect(Collectors.toList());

    }

    //Retrieve a specific subtask using id
    @Override
    public ResponseSubTaskDto getSubTaskById(Long id){
        SubTask subTask = subTaskRepository.findById(id).orElse(null);
        if(subTask == null){
            throw new SubTaskNotFoundException("Sub Task not found with id: " + id);
        }
        return subtaskUtil.convertToResponseSubTaskDto(subTask);
    }

    // Retrieve subtasks for a specific main task
//    @Override
//    public List<ResponseSubTaskDto> getSubTasksByMainTaskId(Long id) {
//        MainTask mainTask = mainTaskRepository.findById(id).orElse(null);
//        if(mainTask == null){
//            throw new MainTaskNotFoundException("Main Task not found with id: " + id);
//        }
//        List<SubTask> subTasks = subTaskRepository.findByMainTaskId(id);
//        return subTasks.stream()
//                .map(subtaskUtil::convertToResponseSubTaskDto)
//                .collect(Collectors.toList());
//    }


    @Override
    public ResponseSubTaskDto updateSubTask(Long subTaskId, RequestSubTaskDto requestSubTaskDto) {

        // Fetch the existing SubTask
        SubTask existingsubTask = subTaskRepository.findById(subTaskId).orElse(null);
        if(existingsubTask == null) {
            throw new SubTaskNotFoundException("Subtask not found with id: " + subTaskId);
        }

        //fetch and set the MainTask
        if (requestSubTaskDto.getMainTaskId() != null) {
            MainTask mainTask = mainTaskRepository.findById(requestSubTaskDto.getMainTaskId()).orElse(null);
            if(mainTask == null){
                throw new MainTaskNotFoundException("Main task not found with id: " + requestSubTaskDto.getMainTaskId());
            }
            existingsubTask.setMainTask(mainTask);
        }

        // update fields
        if (requestSubTaskDto.getTaskname() != null) {
            existingsubTask.setTaskname(requestSubTaskDto.getTaskname());
        }
        if (requestSubTaskDto.getStatus() != null) {
            existingsubTask.setStatus(requestSubTaskDto.getStatus());
        }
        if (requestSubTaskDto.getStartDate() != null) {
            existingsubTask.setStartDate(requestSubTaskDto.getStartDate());
        }
        if (requestSubTaskDto.getEndDate() != null) {
            existingsubTask.setEndDate(requestSubTaskDto.getEndDate());
        }
        if (requestSubTaskDto.getDescription() != null) {
            existingsubTask.setDescription(requestSubTaskDto.getDescription());
        }

        // Save the updated SubTask
        SubTask updatedSubTask = subTaskRepository.save(existingsubTask);
        return subtaskUtil.convertToResponseSubTaskDto(updatedSubTask);
    }



    // Delete a subtask by ID
    @Override
    @Transactional
    public void deleteSubTask(Long id) {
        Optional<SubTask> subTask = subTaskRepository.findById(id);

        if (subTask.isPresent()) {
            subTaskRepository.deleteById(id);
        } else {
            throw new RuntimeException("SubTask with ID " + id + " not found.");
        }
    }

    // Delete all subtasks of a specific main task

    //public void deleteAllSubTasks(Long mainTaskId) {

    //if(mainTaskId != null){
    // subTaskRepository.deleteSubTaskByMainTaskId(mainTaskId);
    // } else {
    //throw new RuntimeException("MainTask with ID " + mainTaskId + " not found.");
    //}


    @Override
    @Transactional
    public void deleteAllSubTasksbyMaintask(Long mainTaskId) {
        if (!mainTaskRepository.existsById(mainTaskId)) {
            throw new MainTaskNotFoundException("MainTask with ID " + mainTaskId + " not found.");
        }
        subTaskRepository.deleteAllSubTasksBymaintask(mainTaskId);
    }

    // Delete all subtasks in all main tasks
    @Override
    @Transactional
    public void deleteAllSubTasks() {
        subTaskRepository.deleteAllSubTasks();
    }










}
