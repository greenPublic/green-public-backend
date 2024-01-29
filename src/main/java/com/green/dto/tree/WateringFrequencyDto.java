package com.green.dto.tree;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WateringFrequencyDto {
    private String frequencyName;
    private int frequencyValue;
    private String description;
}
