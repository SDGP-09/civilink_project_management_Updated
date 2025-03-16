package com.civilink.civilink_project_management.services;

import com.civilink.civilink_project_management.dtos.requests.RequestMaterialDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseMaterialDto;

import java.util.List;


public interface MaterialService {

     ResponseMaterialDto saveMaterial(RequestMaterialDto materialDTO);
     List<ResponseMaterialDto> getAllMaterials();
     ResponseMaterialDto  getMaterialById(Long id);
     ResponseMaterialDto updateMaterial(Long id, RequestMaterialDto materialDTO);
     void deleteMaterial(Long id);

}
