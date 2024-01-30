package com.green.controller.tree;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/watering-frequencies")
public class WateringFrequencyController {

    private final WateringFrequencyService wateringFrequencyService;


    @PostMapping
    public ResponseEntity<WateringFrequency> saveWateringFrequency(
            @RequestBody WateringFrequency wateringFrequency) {
        WateringFrequency savedFrequency =
                wateringFrequencyService.saveWateringFrequency(wateringFrequency);
        return new ResponseEntity<>(savedFrequency, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<WateringFrequency>> getAllWateringFrequencies() {
        List<WateringFrequency> frequencies = wateringFrequencyService.getAllWateringFrequencies();
        return new ResponseEntity<>(frequencies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WateringFrequency> getWateringFrequencyById(@PathVariable String id) {
        Optional<WateringFrequency> frequency =
                wateringFrequencyService.getWateringFrequencyById(id);
        return frequency.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/byName/{frequencyName}")
    public ResponseEntity<List<WateringFrequency>> getWateringFrequencyByFrequencyName(
            @PathVariable String frequencyName) {
        List<WateringFrequency> frequencies =
                wateringFrequencyService.getWateringFrequencyByFrequencyName(frequencyName);
        return new ResponseEntity<>(frequencies, HttpStatus.OK);
    }

    @GetMapping("/byLanguage/{language}")
    public ResponseEntity<List<WateringFrequency>> getWateringFrequencyByLanguage(
            @PathVariable String language) {
        List<WateringFrequency> frequencies =
                wateringFrequencyService.getWateringFrequencyByLanguage(language);
        return new ResponseEntity<>(frequencies, HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<WateringFrequency> updateWateringFrequency(
            @RequestBody WateringFrequency wateringFrequency) {
        WateringFrequency updatedFrequency =
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
            @RequestBody WateringFrequency wateringFrequency) {
        wateringFrequencyService.deleteWateringFrequency(wateringFrequency);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAllWateringFrequencies() {
        wateringFrequencyService.deleteAllWateringFrequencies();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

