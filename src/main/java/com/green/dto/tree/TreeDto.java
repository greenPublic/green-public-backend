package com.green.dto.tree;

import com.green.constants.Season;
import com.green.constants.Sunlight;
import com.green.entity.translation.Language;
import com.green.entity.tree.SoilType;
import com.green.entity.tree.TreeSpecies;
import com.green.entity.tree.WateringFrequency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TreeDto {

    private String name;
    private Sunlight sunlightRequirement;
    private double pH;
    private Season season;
    private double plantingDepth;
    private String spacingRequirement;
    private String additionalNotes;
    private Language language;
    private WateringFrequency wateringFrequency;
    private SoilType soilType;
    private TreeSpecies species;
}
