package com.src.controller;

import com.src.dto.CityDto;
import com.src.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController {

    private static CityService cityService;

    @RequestMapping("/findAll")
    public void findAllCity(){cityService.findAllCity();}

    @RequestMapping("/allHumanByCity")
    public void getAllHumanByCityName(@RequestBody String city){cityService.getAllHumanByCityName(city);}

    @PostMapping("/addCity")
    public void addCity(@RequestBody CityDto cityDto){cityService.addCity(cityDto);}

    @DeleteMapping
    public void deleteById(@RequestBody int id){cityService.deleteById(id);}
}
