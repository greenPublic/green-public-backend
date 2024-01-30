package com.green.dto.informations;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InformationDto {

    private String header;

    private String description;

}
