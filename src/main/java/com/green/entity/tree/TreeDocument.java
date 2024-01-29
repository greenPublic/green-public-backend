package com.green.entity.tree;

import com.green.constants.Season;
import com.green.constants.Sunlight;
import com.green.entity.translation.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("tree")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TreeDocument {

    @Id
    private String id;
    @Field("name")
    private String name;
    @Field("sunlightRequirement")
    private Sunlight sunlightRequirement;
    @Field("pH")
    private double pH;
    @Field("season")
    private Season season;
    @Field("plantingDepth")
    private double plantingDepth;
    @Field("spacingRequirement")
    private String spacingRequirement;
    @Field("additionalNotes")
    private String additionalNotes;
    @DBRef
    @Field("language")
    private Language language;

    @DBRef
    @Field("wateringFrequency")
    private WateringFrequency wateringFrequency;

    @DBRef
    @Field("soilType")
    private Language soilType;

    @DBRef
    @Field("species")
    private TreeSpecies species;
}
