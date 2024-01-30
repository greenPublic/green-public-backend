package com.green.service.implementation.suggestions;

import com.green.dto.suggestions.SuggestionsDto;
import com.green.entity.suggestions.Suggestions;
import com.green.repository.SuggestionsRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SuggestionsService {

    private final SuggestionsRepository suggestionsRepository;
    private final ModelMapper modelMapper;


    public SuggestionsDto createSuggestions(SuggestionsDto suggestionsDto) {
        Suggestions suggestions = modelMapper.map(suggestionsDto, Suggestions.class);
        Suggestions savedSuggestions = suggestionsRepository.save(suggestions);
        return modelMapper.map(savedSuggestions, SuggestionsDto.class);
    }

    public Optional<SuggestionsDto> getSuggestionsById(String id) {
        Optional<Suggestions> suggestionsOptional = suggestionsRepository.findById(id);
        return suggestionsOptional.map(
                suggestions -> modelMapper.map(suggestions, SuggestionsDto.class));
    }

    public List<SuggestionsDto> getAllSuggestions() {
        List<Suggestions> suggestionsList = suggestionsRepository.findAll();
        return suggestionsList.stream()
                .map(suggestions -> modelMapper.map(suggestions, SuggestionsDto.class))
                .collect(Collectors.toList());
    }

    public SuggestionsDto updateSuggestions(String id, SuggestionsDto suggestionsDto) {
        if (suggestionsRepository.existsById(id)) {
            Suggestions suggestions = modelMapper.map(suggestionsDto, Suggestions.class);
            suggestions.setId(id);
            Suggestions updatedSuggestions = suggestionsRepository.save(suggestions);
            return modelMapper.map(updatedSuggestions, SuggestionsDto.class);
        }
        return null;
    }

    public void deleteSuggestions(String id) {
        suggestionsRepository.deleteById(id);
    }
}

