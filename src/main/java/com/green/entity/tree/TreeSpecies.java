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


@Document("treeSpecies")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TreeSpecies {
    @Id
    private String id;
    @Field("name")
    private String name;
    @Field("scientificName")
    private String scientificName;
    @Field("description")
    private String description;
    @DBRef
    @Field("language")
    private Language language;
}
