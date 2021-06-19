package com.src.controller;

import com.src.dto.CountryDto;
import com.src.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/findAll")
    public List<CountryDto> findAllCountry(){return countryService.findAllCountry();}

    @GetMapping("/allCityByCountry")
    public void getAllCityByCountryName(@RequestBody String country){
        countryService.getAllCityByCountryName(country);
    }

    @GetMapping("/getCountryCapital")
    public void getCapitalByCountryName(@RequestBody String country){
        countryService.getCapitalByCountryName(country);
    }

    @PostMapping
    public void addCountry(@RequestBody CountryDto countryDto) throws SQLException {
        countryService.addCountry(countryDto);
    }

    @DeleteMapping
    public void deleteById(@RequestBody int id){countryService.deleteById(id);}
}
