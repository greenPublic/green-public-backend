package com.green.service.implementation.tree;

import com.green.entity.translation.Language;
import com.green.entity.tree.WateringFrequency;
import com.green.repository.WateringFrequencyRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WateringFrequencyService {

    private final WateringFrequencyRepository wateringFrequencyRepository;

    public WateringFrequency saveWateringFrequency(WateringFrequency wateringFrequency) {
        return wateringFrequencyRepository.save(wateringFrequency);
    }

    public List<WateringFrequency> getAllWateringFrequencies() {
        return wateringFrequencyRepository.findAll();
    }

    public Optional<WateringFrequency> getWateringFrequencyById(String id) {
        return wateringFrequencyRepository.findById(id);
    }

    public List<WateringFrequency> getWateringFrequencyByFrequencyName(String frequencyName) {
        return wateringFrequencyRepository.findByFrequencyName(frequencyName);
    }

    public List<WateringFrequency> getWateringFrequencyByLanguage(String language) {
        return wateringFrequencyRepository.findByLanguage_Id(language);
    }

    public WateringFrequency updateWateringFrequency(WateringFrequency wateringFrequency) {
        return wateringFrequencyRepository.save(wateringFrequency);
    }

    public void deleteWateringFrequencyById(String id) {
        wateringFrequencyRepository.deleteById(id);
    }

    public void deleteWateringFrequency(WateringFrequency wateringFrequency) {
        wateringFrequencyRepository.delete(wateringFrequency);
    }

    public void deleteAllWateringFrequencies() {
        wateringFrequencyRepository.deleteAll();
    }
}

