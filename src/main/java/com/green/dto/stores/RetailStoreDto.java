package com.green.dto.stores;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetailStoreDto {

    private String name;

    private String address;

    private double latitude;

    private double longitude;

    private String phoneNumber;

    private String website;

    private String openingHours;
}
