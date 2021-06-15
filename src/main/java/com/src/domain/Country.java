package com.src.domain;

public class Country {

    private int id;
    private String name;
    private long population;
    private String continent;
    private long gdp;

    public void Country(){}

    public void Country(String name, long population, String continent, long gdp){
        name = this.name;
        population = this.population;
        continent = this.continent;
        gdp = this.gdp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public long getGdp() {
        return gdp;
    }

    public void setGdp(long gdp) {
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
