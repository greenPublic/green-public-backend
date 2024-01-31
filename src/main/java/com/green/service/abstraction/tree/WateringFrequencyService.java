package com.green.service.abstraction.tree;

import com.green.dto.tree.WateringFrequencyDto;
import java.util.List;
import java.util.Optional;

public interface WateringFrequencyService {

    WateringFrequencyDto saveWateringFrequency(WateringFrequencyDto wateringFrequencyDto,
                                               String lang);

    List<WateringFrequencyDto> getAllWateringFrequencies(String lang);

    Optional<WateringFrequencyDto> getWateringFrequencyById(String id);

    List<WateringFrequencyDto> getWateringFrequencyByFrequencyName(String frequencyName);

    List<WateringFrequencyDto> getWateringFrequencyByLanguage(String language);

    WateringFrequencyDto updateWateringFrequency(WateringFrequencyDto wateringFrequencyDto);

    void deleteWateringFrequencyById(String id);

    void deleteWateringFrequency(WateringFrequencyDto wateringFrequencyDto);

    void deleteAllWateringFrequencies();
}


