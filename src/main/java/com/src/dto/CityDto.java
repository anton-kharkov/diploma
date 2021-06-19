package com.src.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityDto {

    private int id;
    private String name;
    private String country;
    private boolean capital;
    private int population;
}
