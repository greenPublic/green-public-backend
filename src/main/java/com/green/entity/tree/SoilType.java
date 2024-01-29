package com.green.entity.tree;


import com.green.entity.translation.TextContent;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("soil_type")
public class SoilType {

    private String description;

    private TextContent name;
}