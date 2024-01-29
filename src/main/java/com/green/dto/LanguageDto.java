package com.green.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LanguageDto {
    private String language;

    private String languageAbbr;
}
