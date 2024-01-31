package com.green.service.abstraction.suggestions;

import com.green.dto.suggestions.SuggestionsDto;
import java.util.List;
import java.util.Optional;

public interface SuggestionsService {

    SuggestionsDto createSuggestions(SuggestionsDto suggestionsDto, String lang);

    Optional<SuggestionsDto> getSuggestionsById(String id);

    List<SuggestionsDto> getAllSuggestions(String lang);

    SuggestionsDto updateSuggestions(String id, SuggestionsDto suggestionsDto);

    void deleteSuggestions(String id);
}

