package com.green.entity.tree;


import com.green.entity.translation.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("wateringFrequency")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WateringFrequency {

    @Id
    private String id;
    @Field("frequencyName")
    private String frequencyName;  // e.g., "Daily," "Weekly," "Monthly"
    @Field("frequencyValue")
    private int frequencyValue;     // e.g., if Weekly, how many times per week
    @Field("description")
    private String description;

    @DBRef
    @Field("language")
    private Language language;
}
