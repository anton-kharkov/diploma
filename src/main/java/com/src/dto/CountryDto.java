package com.src.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {

    private int id;
    private String name;
    private int population;
    private String continent;
    private int gdp;
}
