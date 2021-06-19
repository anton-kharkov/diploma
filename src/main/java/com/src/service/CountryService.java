package com.src.service;

import com.src.dao.CountryDaoDb;
import com.src.domain.City;
import com.src.domain.Country;
import com.src.dto.CityDto;
import com.src.dto.CountryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryDaoDb countryDaoDb;

    @Transactional
    public void addCountry(CountryDto countryDto) throws SQLException {
        Country country = fromCountryDto(countryDto);
        countryDaoDb.addCountry(country);
    }

    @Transactional
    public List<CountryDto> findAllCountry(){
        return countryDaoDb.findAllCountry()
                .stream()
                .map(this::getBuildCountry)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteById(int id){countryDaoDb.deleteById(id);}

    @Transactional
    public List<CityDto> getAllCityByCountryName(String country){
        return countryDaoDb.getAllCityByCountryName(country)
                .stream()
                .map(this::getBuildCity)
                .collect(Collectors.toList());
    }

    @Transactional
    public CityDto getCapitalByCountryName(String country){
         City city = countryDaoDb.getCapitalByCountryName(country);
         CityDto cityDto = getBuildCity(city);
         return cityDto;
    }

    private CityDto getBuildCity(com.src.domain.City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .country(city.getCountry())
                .capital(city.isCapital())
                .population(city.getPopulation())
                .build();
    }


    private CountryDto getBuildCountry(Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .population(country.getPopulation())
                .continent(country.getContinent())
                .gdp(country.getGdp())
                .build();
    }

    private Country fromCountryDto(CountryDto countryDto){
        return Country.builder()
                .id(countryDto.getId())
                .name(countryDto.getName())
                .population(countryDto.getPopulation())
                .build();
    }
}
