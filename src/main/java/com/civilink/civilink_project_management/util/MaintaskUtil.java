package com.civilink.civilink_project_management.util;

import com.civilink.civilink_project_management.dtos.responses.ResponseMainTaskDto;
import com.civilink.civilink_project_management.entities.MainTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MaintaskUtil {

    private ContractorUtil contractorUtil;
    private SubtaskUtil subtaskUtil;


    public MaintaskUtil(ContractorUtil contractorUtil,SubtaskUtil subtaskUtil) {
        this.contractorUtil = contractorUtil;
        this.subtaskUtil = subtaskUtil;
    }

    public ResponseMainTaskDto convertToResponseMainTaskDto(MainTask mainTask) {

        ResponseMainTaskDto responseMainTaskDto = new ResponseMainTaskDto();
        responseMainTaskDto.setId(mainTask.getId());
        responseMainTaskDto.setTaskname(mainTask.getTaskname());
        responseMainTaskDto.setStatus(mainTask.getStatus());
        responseMainTaskDto.setStartDate(mainTask.getStartDate());
        responseMainTaskDto.setEndDate(mainTask.getEndDate());
        responseMainTaskDto.setDescription(mainTask.getDescription());
        responseMainTaskDto.setContractor(contractorUtil.convertToResponseContractorDto(mainTask.getContractor()));

        responseMainTaskDto.setSubtasks(mainTask.getSubtasks().stream()
                .map(subtask -> subtaskUtil.convertToResponseSubTaskDto(subtask))
                .collect(Collectors.toList()));
        return responseMainTaskDto;
    }

}
