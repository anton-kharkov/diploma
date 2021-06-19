package com.src.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Country {

    private int id;
    private String name;
    private int population;
    private String continent;
    private int gdp;

    public Country(){}

    public Country(int id, String name, int population, String continent, int gdp){
        id = this.id;
        name = this.name;
        population = this.population;
        continent = this.continent;
        gdp = this.gdp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getGdp() {
        return gdp;
    }

    public void setGdp(int gdp) {
        this.gdp = gdp;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", continent='" + continent + '\'' +
                ", gdp=" + gdp +
                '}';
    }
}
