package com.green.service.implementation.tree;

import com.green.dto.tree.SoilTypeDto;
import com.green.entity.translation.Language;
import com.green.entity.tree.SoilType;
import com.green.repository.LanguageRepository;
import com.green.repository.SoilTypeRepository;
import com.green.service.abstraction.tree.SoilTypeService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SoilTypeServiceImpl implements SoilTypeService {

    private final SoilTypeRepository soilTypeRepository;
    private final ModelMapper modelMapper;
    private final LanguageRepository languageRepository;


    public SoilTypeDto createSoilType(SoilTypeDto soilTypeDto, String lang) {
        SoilType soilType = modelMapper.map(soilTypeDto, SoilType.class);

        Language byLanguageAbbr = languageRepository.findByLanguageAbbr(lang);
        soilType.setLanguage(byLanguageAbbr);

        soilType = soilTypeRepository.save(soilType);
        return modelMapper.map(soilType, SoilTypeDto.class);
    }

    public List<SoilTypeDto> getAllSoilTypes(String lang) {
        Language byLanguageAbbr = languageRepository.findByLanguageAbbr(lang);
        String languageAbbrId = byLanguageAbbr.getId();

        List<SoilType> soilTypes = soilTypeRepository.findAllByLanguage(languageAbbrId);
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

