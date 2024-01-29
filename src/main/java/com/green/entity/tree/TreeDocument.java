package com.green.entity.tree;

import com.green.constants.Season;
import com.green.constants.Sunlight;
import com.green.entity.translation.TextContent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
    private Long id;

    private TextContent name;

    @Field("sunlightRequirement")
    private Sunlight sunlightRequirement;
    @Field("soilType")
    private SoilType soilType;
    @Field("pH")
    private double pH;
    @Field("wateringFrequency")
    private int wateringFrequency;
    @Field("season")
    private Season season;
    @Field("plantingDepth")
    private double plantingDepth;
    @Field("spacingRequirement")
    private String spacingRequirement;

    @Field("additionalNotes")
    @DBRef
    private TextContent additionalNotes;
}
