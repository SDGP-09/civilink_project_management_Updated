package com.civilink.civilink_project_management.util;

import com.civilink.civilink_project_management.dtos.responses.ResponseContractorDto;
import com.civilink.civilink_project_management.entities.Contractor;
import org.springframework.stereotype.Component;

@Component
public class ContractorUtil {

    public ResponseContractorDto convertToResponseContractorDto(Contractor contractor) {
        ResponseContractorDto responseContractorDto = new ResponseContractorDto();
        responseContractorDto.setId(contractor.getId());
        responseContractorDto.setName(contractor.getName());
        responseContractorDto.setEmail(contractor.getEmail());
        responseContractorDto.setContact(contractor.getContact());
        return responseContractorDto;
    }

}
