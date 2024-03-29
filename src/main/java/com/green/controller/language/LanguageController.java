package com.green.controller.language;

import com.green.dto.language.LanguageDto;
import com.green.service.implementation.language.LanguageServiceImpl;
import java.util.List;
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

    private final LanguageServiceImpl languageServiceImpl;

    @PostMapping
    public ResponseEntity<LanguageDto> saveLanguage(@RequestBody LanguageDto language) {
        return languageServiceImpl.saveLanguage(language);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageDto> findLanguageById(@PathVariable String id) {
        LanguageDto language = languageServiceImpl.findLanguageById(id);
        return new ResponseEntity<>(language, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LanguageDto>> findAllLanguages() {
        List<LanguageDto> languages = languageServiceImpl.findAllLanguages();
        return new ResponseEntity<>(languages, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguageById(@PathVariable String id) {
        languageServiceImpl.deleteLanguageById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLanguage(@RequestBody LanguageDto language) {
        languageServiceImpl.deleteLanguage(language);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
