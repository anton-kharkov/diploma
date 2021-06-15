package com.src.domain;

public class City {

    private int id;
    private String name;
    private String country;
    private boolean capital;
    private long population;

    public void City(){}

    public void City(String name, String country, boolean capital, long population){
        name = this.name;
        country = this.country;
        capital = this.capital;
        population = this.population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", capital=" + capital +
                ", population=" + population +
                '}';
    }
}
