package com.green.entity.informations;

import com.green.entity.translation.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("language")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Information {
    @Id
    private String id;

    @Field("header")
    private String header;

    @Field("description")
    private String description;

    @DBRef
    @Field("language")
    private Language language;

}
