package com.green.service.abstraction.language;

import com.green.dto.language.LanguageDto;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface LanguageService {

    ResponseEntity<LanguageDto> saveLanguage(LanguageDto languageDto);

    LanguageDto findLanguageById(String id);

    List<LanguageDto> findAllLanguages();

    void deleteLanguageById(String id);

    void deleteLanguage(LanguageDto languageDto);
}

