package com.green.service.implementation.tree;

import com.green.dto.tree.WateringFrequencyDto;
import com.green.entity.translation.Language;
import com.green.entity.tree.WateringFrequency;
import com.green.repository.LanguageRepository;
import com.green.repository.WateringFrequencyRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WateringFrequencyService {

    private final WateringFrequencyRepository wateringFrequencyRepository;
    private final LanguageRepository languageRepository;
    private final ModelMapper modelMapper;


    public WateringFrequencyDto saveWateringFrequency(WateringFrequencyDto wateringFrequencyDto, String lang) {
        Language byLanguageAbbr = languageRepository.findByLanguageAbbr(lang);
        String languageAbbrId = byLanguageAbbr.getId();

        WateringFrequency wateringFrequency = modelMapper.map(wateringFrequencyDto, WateringFrequency.class);
        wateringFrequency.setLanguage(byLanguageAbbr);

        WateringFrequency savedFrequency = wateringFrequencyRepository.save(wateringFrequency);

        return modelMapper.map(savedFrequency, WateringFrequencyDto.class);
    }

    public List<WateringFrequencyDto> getAllWateringFrequencies(String lang) {
        Language byLanguageAbbr = languageRepository.findByLanguageAbbr(lang);
        String languageAbbrId = byLanguageAbbr.getId();

        List<WateringFrequency> wateringFrequencies = wateringFrequencyRepository.findByLanguage_Id(languageAbbrId);
        return wateringFrequencies.stream()
                .map(frequency -> modelMapper.map(frequency, WateringFrequencyDto.class))
                .collect(Collectors.toList());
    }

    public Optional<WateringFrequencyDto> getWateringFrequencyById(String id) {
        Optional<WateringFrequency> wateringFrequencyOptional = wateringFrequencyRepository.findById(id);
        return wateringFrequencyOptional.map(frequency -> modelMapper.map(frequency, WateringFrequencyDto.class));
    }

    public List<WateringFrequencyDto> getWateringFrequencyByFrequencyName(String frequencyName) {
        List<WateringFrequency> wateringFrequencies = wateringFrequencyRepository.findByFrequencyName(frequencyName);
        return wateringFrequencies.stream()
                .map(frequency -> modelMapper.map(frequency, WateringFrequencyDto.class))
                .collect(Collectors.toList());
    }

    public List<WateringFrequencyDto> getWateringFrequencyByLanguage(String language) {
        List<WateringFrequency> wateringFrequencies = wateringFrequencyRepository.findByLanguage_Id(language);
        return wateringFrequencies.stream()
                .map(frequency -> modelMapper.map(frequency, WateringFrequencyDto.class))
                .collect(Collectors.toList());
    }

    public WateringFrequencyDto updateWateringFrequency(WateringFrequencyDto wateringFrequencyDto) {
        WateringFrequency wateringFrequency = modelMapper.map(wateringFrequencyDto, WateringFrequency.class);
        WateringFrequency updatedFrequency = wateringFrequencyRepository.save(wateringFrequency);
        return modelMapper.map(updatedFrequency, WateringFrequencyDto.class);
    }

    public void deleteWateringFrequencyById(String id) {
        wateringFrequencyRepository.deleteById(id);
    }

    public void deleteWateringFrequency(WateringFrequencyDto wateringFrequencyDto) {
        WateringFrequency wateringFrequency = modelMapper.map(wateringFrequencyDto, WateringFrequency.class);
        wateringFrequencyRepository.delete(wateringFrequency);
    }

    public void deleteAllWateringFrequencies() {
        wateringFrequencyRepository.deleteAll();
    }
}

