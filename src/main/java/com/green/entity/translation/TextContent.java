package com.green.entity.translation;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("textContent")
@Builder
@Data
public class TextContent {

    @Id
    private Long id;

    @Field("text")
    private String text;

    @Field("language")
    @DBRef
    private Language language;


}
