package com.green.entity.suggestions;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("suggestions")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Suggestions {

    @Id
    private String id;

    @Field("title")
    private String title;

    @Field("description")
    private String description;

    @Field("createdBy")
    private String createdBy;

    @Field("createdAt")
    private LocalDateTime createdAt;

}
