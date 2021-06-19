package com.src.service;

import com.src.dao.CityDaoDb;
import com.src.domain.City;
import com.src.domain.Human;
import com.src.dto.CityDto;
import com.src.dto.HumanDto;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityDaoDb cityDaoDb;

    @Transactional
    public void addCity(CityDto cityDto){
        City city = fromCityDto(cityDto);
        cityDaoDb.addCity(city);
    }

    @Transactional
    public List<CityDto> findAllCity(){
        return cityDaoDb.findAllCity()
                .stream()
                .map(this::getBuildCity)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteById(int id){cityDaoDb.deleteById(id);}

    @Transactional
    public List<HumanDto> getAllHumanByCityName(String city){
        return cityDaoDb.getAllHumanByCityName(city)
                .stream()
                .map(this::getBuildHuman)
                .collect(Collectors.toList());
    }


    private HumanDto getBuildHuman(Human human) {
        return HumanDto.builder()
                .id(human.getId())
                .firstname(human.getFirstName())
                .lastname(human.getLastName())
                .patronymic(human.getPatronymic())
                .yearOfBirth(human.getYearOfBirth())
                .inn(human.getInn())
                .country(human.getCountry())
                .gender(human.getGender())
                .build();
    }

    private CityDto getBuildCity(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .country(city.getCountry())
                .capital(city.isCapital())
                .population(city.getPopulation())
                .build();
    }


    private City fromCityDto(CityDto cityDto){
        return City.builder()
                .id(cityDto.getId())
                .name(cityDto.getName())
                .country(cityDto.getCountry())
                .capital(cityDto.isCapital())
                .population(cityDto.getPopulation())
                .build();
    }
}
