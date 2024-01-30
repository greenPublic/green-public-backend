package com.green.service.implementation.language;

import com.green.dto.language.LanguageDto;
import com.green.entity.translation.Language;
import com.green.repository.LanguageRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LanguageService {

    private final LanguageRepository languageRepository;
    private final ModelMapper modelMapper;

    public ResponseEntity<LanguageDto> saveLanguage(LanguageDto languageDto) {
        Language language = modelMapper.map(languageDto, Language.class);
        Language byLanguageAbbr =
                languageRepository.findByLanguageAbbr(languageDto.getLanguageAbbr());

        if (byLanguageAbbr != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Language languageSaved = languageRepository.save(language);
        return ResponseEntity.ok(modelMapper.map(languageSaved, LanguageDto.class));
    }

    public LanguageDto findLanguageById(String id) {
        Optional<Language> language = languageRepository.findById(id);
        return modelMapper.map(language, LanguageDto.class);
    }

    public List<LanguageDto> findAllLanguages() {
        List<Language> all = languageRepository.findAll();
        return all.stream()
                .map(language -> modelMapper.map(language, LanguageDto.class))
                .toList();

    }

    public void deleteLanguageById(String id) {
        languageRepository.deleteById(id);
    }

    public void deleteLanguage(LanguageDto languageDto) {
        Language language = modelMapper.map(languageDto, Language.class);
        languageRepository.delete(language);
    }
}
