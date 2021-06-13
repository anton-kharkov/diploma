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
}
