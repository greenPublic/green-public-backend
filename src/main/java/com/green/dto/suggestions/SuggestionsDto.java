package com.green.dto.suggestions;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuggestionsDto {

    private String title;

    private String description;

    private String createdBy;

    private LocalDateTime createdAt;

}
