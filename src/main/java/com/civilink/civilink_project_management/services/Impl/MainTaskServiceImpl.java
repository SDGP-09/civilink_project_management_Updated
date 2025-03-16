package com.civilink.civilink_project_management.services.Impl;

import com.civilink.civilink_project_management.dtos.requests.RequestMainTaskDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseMainTaskDto;
import com.civilink.civilink_project_management.entities.MainTask;
import com.civilink.civilink_project_management.exception.MainTaskNotFoundException;
import com.civilink.civilink_project_management.repositories.MainTaskRepository;
import com.civilink.civilink_project_management.services.MainTaskService;
import com.civilink.civilink_project_management.util.MaintaskUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MainTaskServiceImpl implements MainTaskService {
    private final MainTaskRepository mainTaskRepository;
    private final MaintaskUtil maintaskUtil;

    @Autowired
    public MainTaskServiceImpl(MainTaskRepository mainTaskRepository, MaintaskUtil maintaskUtil) {
        this.mainTaskRepository = mainTaskRepository;
        this.maintaskUtil = maintaskUtil;
    }

    @Override
    public ResponseMainTaskDto createMainTask(RequestMainTaskDto requestMainTaskDto, String groupId) {


        System.out.println(requestMainTaskDto.toString());

        //create main task
        MainTask mainTask = new MainTask();
        mainTask.setTaskName(requestMainTaskDto.getTaskname());
        mainTask.setStatus(requestMainTaskDto.getStatus());
        mainTask.setStartDate(requestMainTaskDto.getStartDate());
        mainTask.setEndDate(requestMainTaskDto.getEndDate());
        mainTask.setDescription(requestMainTaskDto.getDescription());
        mainTask.setGroupId(groupId);
        mainTask.setExpanded(requestMainTaskDto.isExpanded());
        mainTask.setContractorId(requestMainTaskDto.getContractorId());

        // Save to the database
        MainTask savedmainTask = mainTaskRepository.save(mainTask);

        //convert to responsedto
        ResponseMainTaskDto responseMainTaskDto = new ResponseMainTaskDto();
        responseMainTaskDto.setId(savedmainTask.getId());
        responseMainTaskDto.setTaskname(savedmainTask.getTaskName());
        responseMainTaskDto.setStatus(savedmainTask.getStatus());
        responseMainTaskDto.setStartDate(savedmainTask.getStartDate());
        responseMainTaskDto.setEndDate(savedmainTask.getEndDate());
        responseMainTaskDto.setDescription(savedmainTask.getDescription());
        responseMainTaskDto.setExpanded(savedmainTask.isExpanded());
        responseMainTaskDto.setContractorId(savedmainTask.getContractorId());
        return responseMainTaskDto;
    }



    //Rerieve All Main tasks
   // @Override
    //public List<ResponseMainTaskDto> getAllMainTasks(String group){
        //List<MainTask> mainTasks = mainTaskRepository.findAllByGroupId(group);
        //return mainTasks.stream().map(maintaskUtil::convertToResponseMainTaskDto).collect(Collectors.toList());
    //}

    @Override
    public List<ResponseMainTaskDto> getAllMainTasks(String groupId) {
        List<MainTask> mainTasks = mainTaskRepository.findAllMainTasks(groupId);

        // Convert MainTask entities to Response DTOs
        return mainTasks.stream()
                .map(maintaskUtil::convertToResponseMainTaskDto)
                .collect(Collectors.toList());
    }



    //Retrieve a Specific Main task
    @Override
    public ResponseMainTaskDto getMainTaskById(Long id,String groupId){
        MainTask mainTask = mainTaskRepository.findById(id).orElse(null);
        if(mainTask == null || !mainTask.getGroupId().equals(groupId)){
            throw new MainTaskNotFoundException("Main Task not found with id: " + id);
        }
        return maintaskUtil.convertToResponseMainTaskDto(mainTask);
    }






    @Override
    public ResponseMainTaskDto updateMainTask(Long taskId, RequestMainTaskDto requestMainTaskDto, String groupId) {

        // Retrieve the existing main task
        MainTask existingTask = mainTaskRepository.findById(taskId).orElse(null);
        if(existingTask == null || !existingTask.getGroupId().equals(groupId)){
            throw new MainTaskNotFoundException("Main Task not found with id: " + taskId);
        }


        // Update fields
        if (requestMainTaskDto.getTaskname() != null) {
            existingTask.setTaskName(requestMainTaskDto.getTaskname());
        }
        if (requestMainTaskDto.getStatus() != null) {
            existingTask.setStatus(requestMainTaskDto.getStatus());
        }
        if (requestMainTaskDto.getStartDate() != null) {
            existingTask.setStartDate(requestMainTaskDto.getStartDate());
        }
        if (requestMainTaskDto.getEndDate() != null) {
            existingTask.setEndDate(requestMainTaskDto.getEndDate());
        }
        if (requestMainTaskDto.getDescription() != null) {
            existingTask.setDescription(requestMainTaskDto.getDescription());
        }
        if (requestMainTaskDto.getContractorId() != null) { // Allow updating contractor
            existingTask.setContractorId(requestMainTaskDto.getContractorId());
        }
        existingTask.setExpanded(requestMainTaskDto.isExpanded());

        // Save the updated task
        MainTask updatedTask = mainTaskRepository.save(existingTask);

        // Convert to response DTO
        ResponseMainTaskDto responseMainTaskDto = new ResponseMainTaskDto();
        responseMainTaskDto.setId(updatedTask.getId());
        responseMainTaskDto.setTaskname(updatedTask.getTaskName());
        responseMainTaskDto.setStatus(updatedTask.getStatus());
        responseMainTaskDto.setStartDate(updatedTask.getStartDate());
        responseMainTaskDto.setEndDate(updatedTask.getEndDate());
        responseMainTaskDto.setDescription(updatedTask.getDescription());
        responseMainTaskDto.setExpanded(updatedTask.isExpanded());
        responseMainTaskDto.setContractorId(updatedTask.getContractorId());

        return responseMainTaskDto;
    }






    //delete main task using id
    @Override
    public void deleteMainTask(Long id, String groupId) {
        MainTask mainTask = mainTaskRepository.findById(id).orElse(null);
        if (mainTask == null || !mainTask.getGroupId().equals(groupId)) {
            throw new MainTaskNotFoundException("MainTask with ID " + id + " not found.");
        }
        mainTaskRepository.deleteById(id);
    }


    //delete all main tasks
    @Override
    public void deleteAllMainTasks(String groupId) {
        List<MainTask> mainTasks = mainTaskRepository.findAllByGroupId(groupId);
        if (mainTasks.isEmpty()) {
            throw new MainTaskNotFoundException("No Main Tasks found for group: " + groupId);
        }
        mainTaskRepository.deleteAll(mainTasks);

    }


}
