package com.src.dao;


import com.src.domain.City;
import com.src.domain.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityDao{

    void addCity(City city);

    List<City> findAllCity();

    void deleteById (int id);

    List<Human> getAllHumanByCityName(String city);
}
