package com.civilink.civilink_project_management.services.Impl;

import com.civilink.civilink_project_management.dtos.responses.ResponseMainTaskDto;
import com.civilink.civilink_project_management.entities.MainTask;
import com.civilink.civilink_project_management.repositories.MainTaskRepository;
import com.civilink.civilink_project_management.services.RetrieveMainTasksService;
import com.civilink.civilink_project_management.util.MaintaskUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class RetrieveMainTasksImpl implements RetrieveMainTasksService {
    private final MainTaskRepository mainTaskRepository;
    private final MaintaskUtil maintaskUtil;


    @Autowired
    public RetrieveMainTasksImpl(MainTaskRepository mainTaskRepository,MaintaskUtil maintaskUtil) {
        this.mainTaskRepository = mainTaskRepository;
        this.maintaskUtil = maintaskUtil;
    }

    //Rerieve All Main tasks
    @Override
    public List<ResponseMainTaskDto> getAllMainTasks(){
        List<MainTask> mainTasks = mainTaskRepository.findAll();
        return mainTasks.stream().map(maintaskUtil::convertToResponseMainTaskDto).collect(Collectors.toList());
    }

    //Retrieve a Specific Main task
    @Override
    public ResponseMainTaskDto getMainTaskById(Integer id){
        MainTask mainTask = mainTaskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Main Task not found with id: " + id));
        return maintaskUtil.convertToResponseMainTaskDto(mainTask);
    }


}
