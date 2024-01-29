package com.green.mapper;

import com.green.dto.LanguageDto;
import com.green.entity.translation.Language;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LanguageMapper {

    private final ModelMapper modelMapper;

    public LanguageDto convertToDto(Language language) {
        return modelMapper.map(language, LanguageDto.class);
    }

    public Language convertToEntity(LanguageDto languageDto) {
        return modelMapper.map(languageDto, Language.class);
    }



}

