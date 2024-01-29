package com.green.dto;

import com.green.constants.Season;
import com.green.constants.Sunlight;
import com.green.entity.translation.Language;
import com.green.entity.tree.SoilType;
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
    private SoilType soilType;
    private double pH;
    private int wateringFrequency;
    private Season season;
    private double plantingDepth;
    private String spacingRequirement;
    private String additionalNotes;
}
