package com.civilink.civilink_project_management.services.Impl;

import com.civilink.civilink_project_management.dtos.requests.RequestMaterialDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseMaterialDto;
import com.civilink.civilink_project_management.entities.Material;
import com.civilink.civilink_project_management.repositories.MaterialRepository;
import com.civilink.civilink_project_management.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    private  MaterialRepository materialRepository;

    public MaterialServiceImpl(MaterialRepository materialRepository){
        this.materialRepository = materialRepository;
    }




    @Override
    public ResponseMaterialDto saveMaterial(RequestMaterialDto materialDTO) {
        Material material = new Material(materialDTO.getType(), materialDTO.getQuantity(), materialDTO.getPricePerUnit(), materialDTO.getPaymentStatus());
        Material savedMaterial = materialRepository.save(material);
        return new ResponseMaterialDto(savedMaterial.getId(), savedMaterial.getType(), savedMaterial.getQuantity(), savedMaterial.getPricePerUnit(), savedMaterial.getPaymentStatus());
    }

    @Override
    public List<ResponseMaterialDto> getAllMaterials() {
        return materialRepository.findAll().stream()
                .map(material -> new ResponseMaterialDto(material.getId(), material.getType(), material.getQuantity(), material.getPricePerUnit(), material.getPaymentStatus()))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseMaterialDto  getMaterialById(Long id) {
        Material material = materialRepository.findById(id).orElseThrow(() -> new RuntimeException("Material not found"));
        return new ResponseMaterialDto(material.getId(), material.getType(), material.getQuantity(), material.getPricePerUnit(), material.getPaymentStatus());
    }

    @Override
    public ResponseMaterialDto updateMaterial(Long id, RequestMaterialDto materialDTO) {
        Material material = materialRepository.findById(id).orElseThrow(() -> new RuntimeException("Material not found"));
        material.setType(materialDTO.getType());
        material.setQuantity(materialDTO.getQuantity());
        material.setPricePerUnit(materialDTO.getPricePerUnit());
        material.setPaymentStatus(materialDTO.getPaymentStatus());
        Material updatedMaterial = materialRepository.save(material);
        return new ResponseMaterialDto(updatedMaterial.getId(), updatedMaterial.getType(), updatedMaterial.getQuantity(), updatedMaterial.getPricePerUnit(), updatedMaterial.getPaymentStatus());
    }


    @Override
    public void deleteMaterial(Long id) {
        materialRepository.deleteById(id);
    }

}
