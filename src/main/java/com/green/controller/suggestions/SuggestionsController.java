package com.green.controller.suggestions;

import com.green.dto.suggestions.SuggestionsDto;
import com.green.service.implementation.suggestions.SuggestionsService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/suggestions")
public class SuggestionsController {

    private final SuggestionsService suggestionsService;

    @Autowired
    public SuggestionsController(SuggestionsService suggestionsService) {
        this.suggestionsService = suggestionsService;
    }

    @PostMapping
    public ResponseEntity<SuggestionsDto> createSuggestions(
            @RequestBody SuggestionsDto suggestionsDto) {
        SuggestionsDto createdSuggestions = suggestionsService.createSuggestions(suggestionsDto);
        return new ResponseEntity<>(createdSuggestions, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuggestionsDto> getSuggestionsById(@PathVariable String id) {
        Optional<SuggestionsDto> suggestionsDtoOptional = suggestionsService.getSuggestionsById(id);
        return suggestionsDtoOptional.map(
                        suggestionsDto -> new ResponseEntity<>(suggestionsDto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<SuggestionsDto>> getAllSuggestions() {
        List<SuggestionsDto> suggestionsList = suggestionsService.getAllSuggestions();
        return new ResponseEntity<>(suggestionsList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuggestionsDto> updateSuggestions(@PathVariable String id, @RequestBody
    SuggestionsDto suggestionsDto) {
        SuggestionsDto updatedSuggestions =
                suggestionsService.updateSuggestions(id, suggestionsDto);
        return updatedSuggestions != null ?
                new ResponseEntity<>(updatedSuggestions, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSuggestions(@PathVariable String id) {
        suggestionsService.deleteSuggestions(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

