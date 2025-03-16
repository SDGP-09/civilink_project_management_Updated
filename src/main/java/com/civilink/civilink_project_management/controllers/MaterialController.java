package com.civilink.civilink_project_management.controllers;


import com.civilink.civilink_project_management.dtos.requests.RequestMaterialDto;
import com.civilink.civilink_project_management.dtos.responses.ResponseMaterialDto;
import com.civilink.civilink_project_management.services.MaterialService;
import com.civilink.civilink_project_management.util.StandardResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @PostMapping("/create")
    public ResponseEntity<StandardResponse> createMaterial(@RequestBody RequestMaterialDto materialDTO) {
        ResponseMaterialDto savedMaterial = materialService.saveMaterial(materialDTO);
        return new ResponseEntity<>(
                new StandardResponse(201, "Material created successfully", savedMaterial),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/all")
    public ResponseEntity<StandardResponse> getAllMaterials() {
        List<ResponseMaterialDto> materials = materialService.getAllMaterials();
        return new ResponseEntity<>(
                new StandardResponse(200, "Materials retrieved successfully", materials),
                HttpStatus.OK
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getMaterialById(@PathVariable Long id) {
        ResponseMaterialDto material = materialService.getMaterialById(id);
        return new ResponseEntity<>(
                new StandardResponse(200, "Material retrieved successfully", material),
                HttpStatus.OK
        );
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<StandardResponse> updateMaterial(@PathVariable Long id, @RequestBody RequestMaterialDto materialDTO) {
        ResponseMaterialDto updatedMaterial = materialService.updateMaterial(id, materialDTO);
        return new ResponseEntity<>(
                new StandardResponse(200, "Material updated successfully", updatedMaterial),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StandardResponse> deleteMaterial(@PathVariable Long id) {
        materialService.deleteMaterial(id);
        return new ResponseEntity<>(
                new StandardResponse(200, "Material deleted successfully", "Material with ID " + id + " deleted."),
                HttpStatus.OK
        );
    }


}
