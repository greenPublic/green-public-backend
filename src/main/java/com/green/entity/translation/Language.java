package com.green.entity.translation;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Document("language")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Language {

    @Id
    private String id;

    @Field("language")
    private String language;

    @Field("languageAbbr")
    private String languageAbbr;

}
