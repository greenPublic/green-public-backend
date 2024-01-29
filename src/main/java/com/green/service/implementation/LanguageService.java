package com.green.service.implementation;

import com.green.dto.LanguageDto;
import com.green.entity.translation.Language;
import com.green.repository.LanguageRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LanguageService {

    private final LanguageRepository languageRepository;
    private final ModelMapper modelMapper;

    public LanguageDto saveLanguage(LanguageDto languageDto) {
        Language language = modelMapper.map(languageDto, Language.class);
        Language languageSaved = languageRepository.save(language);
        return modelMapper.map(languageSaved, LanguageDto.class);
    }

    public LanguageDto findLanguageById(UUID id) {
        Optional<Language> language = languageRepository.findById(id);
        return modelMapper.map(language, LanguageDto.class);
    }

//    public List<LanguageDto> findAllLanguages() {
//        List<Language> all = languageRepository.findAll();
//        modelMapper.map(all, new List<Language>() {
//        });
//    }

    public void deleteLanguageById(UUID id) {
        languageRepository.deleteById(id);
    }

    public void deleteLanguage(LanguageDto languageDto) {
        Language language = modelMapper.map(languageDto, Language.class);
        languageRepository.delete(language);
    }
}