package com.green.service.implementation.tree;

import com.green.dto.tree.SoilTypeDto;
import com.green.entity.tree.SoilType;
import com.green.repository.SoilTypeRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoilTypeService {

    private final SoilTypeRepository soilTypeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SoilTypeService(SoilTypeRepository soilTypeRepository, ModelMapper modelMapper) {
        this.soilTypeRepository = soilTypeRepository;
        this.modelMapper = modelMapper;
    }

    public SoilTypeDto createSoilType(SoilTypeDto soilTypeDto) {
        SoilType soilType = modelMapper.map(soilTypeDto, SoilType.class);
        soilType = soilTypeRepository.save(soilType);
        return modelMapper.map(soilType, SoilTypeDto.class);
    }

    public List<SoilTypeDto> getAllSoilTypes() {
        List<SoilType> soilTypes = soilTypeRepository.findAll();
        return soilTypes.stream()
                .map(soilType -> modelMapper.map(soilType, SoilTypeDto.class))
                .collect(Collectors.toList());
    }

    public SoilTypeDto getSoilTypeByName(String name) {
        SoilType soilType = soilTypeRepository.findByName(name);
        return soilType != null ? modelMapper.map(soilType, SoilTypeDto.class) : null;
    }

    public SoilTypeDto updateSoilType(String name, SoilTypeDto updatedSoilTypeDto) {
        SoilType existingSoilType = soilTypeRepository.findByName(name);

        if (existingSoilType != null) {
            modelMapper.map(updatedSoilTypeDto, existingSoilType);
            existingSoilType = soilTypeRepository.save(existingSoilType);
            return modelMapper.map(existingSoilType, SoilTypeDto.class);
        }

        return null; // SoilType with the given name not found
    }

    public void deleteSoilTypeByName(String name) {
        soilTypeRepository.deleteByName(name);
    }
}

