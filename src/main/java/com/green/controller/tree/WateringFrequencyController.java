package com.green.controller.tree;

import com.green.dto.tree.WateringFrequencyDto;
import com.green.entity.tree.WateringFrequency;
import com.green.service.implementation.tree.WateringFrequencyService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/watering-frequencies")
public class WateringFrequencyController {

    private final WateringFrequencyService wateringFrequencyService;


    @PostMapping
    public ResponseEntity<WateringFrequencyDto> saveWateringFrequency(
            @RequestBody WateringFrequencyDto wateringFrequency, @RequestHeader String lang) {
        WateringFrequencyDto savedFrequency =
                wateringFrequencyService.saveWateringFrequency(wateringFrequency, lang);
        return new ResponseEntity<>(savedFrequency, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<WateringFrequencyDto>> getAllWateringFrequencies(@RequestHeader String lang) {
        List<WateringFrequencyDto> frequencies = wateringFrequencyService.getAllWateringFrequencies(lang);
        return new ResponseEntity<>(frequencies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WateringFrequencyDto> getWateringFrequencyById(@PathVariable String id) {
        Optional<WateringFrequencyDto> frequency =
                wateringFrequencyService.getWateringFrequencyById(id);
        return frequency.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/byName/{frequencyName}")
    public ResponseEntity<List<WateringFrequencyDto>> getWateringFrequencyByFrequencyName(
            @PathVariable String frequencyName) {
        List<WateringFrequencyDto> frequencies =
                wateringFrequencyService.getWateringFrequencyByFrequencyName(frequencyName);
        return new ResponseEntity<>(frequencies, HttpStatus.OK);
    }

    @GetMapping("/byLanguage/{language}")
    public ResponseEntity<List<WateringFrequencyDto>> getWateringFrequencyByLanguage(
            @PathVariable String language) {
        List<WateringFrequencyDto> frequencies =
                wateringFrequencyService.getWateringFrequencyByLanguage(language);
        return new ResponseEntity<>(frequencies, HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<WateringFrequencyDto> updateWateringFrequency(
            @RequestBody WateringFrequencyDto wateringFrequency) {
        WateringFrequencyDto updatedFrequency =
                wateringFrequencyService.updateWateringFrequency(wateringFrequency);
        return new ResponseEntity<>(updatedFrequency, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWateringFrequencyById(@PathVariable String id) {
        wateringFrequencyService.deleteWateringFrequencyById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteWateringFrequency(
            @RequestBody WateringFrequencyDto wateringFrequency) {
        wateringFrequencyService.deleteWateringFrequency(wateringFrequency);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAllWateringFrequencies() {
        wateringFrequencyService.deleteAllWateringFrequencies();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

