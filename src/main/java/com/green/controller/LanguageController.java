package com.green.controller;

import com.green.dto.LanguageDto;
import com.green.service.implementation.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "language")
public class LanguageController {

    private final LanguageService languageService;

    @PostMapping
    public ResponseEntity<LanguageDto> saveLanguage(@RequestBody LanguageDto language) {
        LanguageDto savedLanguage = languageService.saveLanguage(language);
        return new ResponseEntity<>(savedLanguage, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageDto> findLanguageById(@PathVariable String id) {
        LanguageDto language = languageService.findLanguageById(id);
        return new ResponseEntity<>(language, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LanguageDto>> findAllLanguages() {
        List<LanguageDto> languages = languageService.findAllLanguages();
        return new ResponseEntity<>(languages, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguageById(@PathVariable String id) {
        languageService.deleteLanguageById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLanguage(@RequestBody LanguageDto language) {
        languageService.deleteLanguage(language);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
