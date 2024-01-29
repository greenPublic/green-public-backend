package com.green.controller;

import com.green.entity.translation.Translation;
import com.green.service.implementation.TranslationService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/translations")
public class TranslationController {

    private final TranslationService translationService;

    @Autowired
    public TranslationController(TranslationService translationService) {
        this.translationService = translationService;
    }

    @PostMapping
    public ResponseEntity<Translation> saveTranslation(@RequestBody Translation translation) {
        Translation savedTranslation = translationService.saveTranslation(translation);
        return new ResponseEntity<>(savedTranslation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Translation> findTranslationById(@PathVariable UUID id) {
        Optional<Translation> optionalTranslation = translationService.findTranslationById(id);
        return optionalTranslation.map(translation -> new ResponseEntity<>(translation, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Translation>> findAllTranslations() {
        List<Translation> translations = translationService.findAllTranslations();
        return new ResponseEntity<>(translations, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTranslationById(@PathVariable UUID id) {
        translationService.deleteTranslationById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTranslation(@RequestBody Translation translation) {
        translationService.deleteTranslation(translation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

