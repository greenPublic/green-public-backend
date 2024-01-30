package com.green.controller.tree;

import com.green.dto.tree.SoilTypeDto;
import com.green.service.implementation.tree.SoilTypeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/soilTypes")
public class SoilTypeController {

    private final SoilTypeService soilTypeService;

    @PostMapping
    public ResponseEntity<SoilTypeDto> createSoilType(@RequestBody SoilTypeDto soilTypeDto) {
        SoilTypeDto createdSoilTypeDto = soilTypeService.createSoilType(soilTypeDto);
        return new ResponseEntity<>(createdSoilTypeDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SoilTypeDto>> getAllSoilTypes() {
        List<SoilTypeDto> soilTypeDtos = soilTypeService.getAllSoilTypes();
        return new ResponseEntity<>(soilTypeDtos, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<SoilTypeDto> getSoilTypeByName(@PathVariable String name) {
        SoilTypeDto soilTypeDto = soilTypeService.getSoilTypeByName(name);
        return soilTypeDto != null
                ? new ResponseEntity<>(soilTypeDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{name}")
    public ResponseEntity<SoilTypeDto> updateSoilType(
            @PathVariable String name,
            @RequestBody SoilTypeDto updatedSoilTypeDto
    ) {
        SoilTypeDto updatedSoilType = soilTypeService.updateSoilType(name, updatedSoilTypeDto);

        return updatedSoilType != null
                ? new ResponseEntity<>(updatedSoilType, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteSoilTypeByName(@PathVariable String name) {
        soilTypeService.deleteSoilTypeByName(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

