package com.green.service.abstraction.tree;

import com.green.dto.tree.SoilTypeDto;
import java.util.List;

public interface SoilTypeService {

    SoilTypeDto createSoilType(SoilTypeDto soilTypeDto, String lang);

    List<SoilTypeDto> getAllSoilTypes(String lang);

    SoilTypeDto getSoilTypeByName(String name);

    SoilTypeDto updateSoilType(String name, SoilTypeDto updatedSoilTypeDto);

    void deleteSoilTypeByName(String name);
}

