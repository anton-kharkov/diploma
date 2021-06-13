package domain;

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
}
