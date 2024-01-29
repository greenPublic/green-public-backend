package com.green.entity.translation;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("language")
@Builder
@Data
public class Language {

    @Id
    private Long id;

    @Field("language")
    private String language;

    @Field("languageAbbr")
    private String languageAbbr;

}
