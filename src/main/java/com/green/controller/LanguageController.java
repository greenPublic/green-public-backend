package com.green.controller;

import com.green.dto.LanguageDto;
import com.green.service.implementation.LanguageService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<LanguageDto> findLanguageById(@PathVariable UUID id) {
        LanguageDto language = languageService.findLanguageById(id);
        return new ResponseEntity<>(language, HttpStatus.OK);
    }

//    @GetMapping
//
//    public ResponseEntity<List<LanguageDto>> findAllLanguages() {
////        List<LanguageDto> languages = languageService.findAllLanguages();
//        return new ResponseEntity<>(languages, HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguageById(@PathVariable UUID id) {
        languageService.deleteLanguageById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLanguage(@RequestBody LanguageDto language) {
        languageService.deleteLanguage(language);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
