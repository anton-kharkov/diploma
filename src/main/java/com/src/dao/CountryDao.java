package com.src.dao;

import com.src.domain.City;
import com.src.domain.Country;
import org.springframework.stereotype.Repository;


import java.sql.SQLException;
import java.util.List;

@Repository
public interface CountryDao{

    void addCountry(Country country) throws SQLException;

    List<Country> findAllCountry();

    void deleteById (int id);

    List<City> getAllCityByCountryName(String country);

    City getCapitalByCountryName(String country);

}
