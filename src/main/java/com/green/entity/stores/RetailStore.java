package com.green.entity.stores;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("retail_locations")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetailStore {

    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("address")
    private String address;

    @Field("latitude")
    private double latitude;

    @Field("longitude")
    private double longitude;

    @Field("phoneNumber")
    private String phoneNumber;

    @Field("website")
    private String website;

    @Field("openingHours")
    private String openingHours;
}
