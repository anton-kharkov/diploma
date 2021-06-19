package com.src.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HumanDto {

    private int id;
    private String firstname;
    private String lastname;
    private String patronymic;
    private int yearOfBirth;
    private int inn;
    private String country;
    private String gender;
}
