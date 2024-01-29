package com.green.entity.translation;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("translation")
public class Translation {
    @Id
    private Long id;
    private String translation;
    private String fieldName;
    private Language language;
    private TextContent textContent;
}
