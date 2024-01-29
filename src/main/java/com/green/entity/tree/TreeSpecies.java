package com.green.entity.tree;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("treeSpecies")
public class TreeSpecies {

    @Id
    private Long id;
    private String name;
    private String scientificName;
    private String description;
}
