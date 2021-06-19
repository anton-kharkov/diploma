package com.src.dao;

import com.src.domain.City;
import com.src.domain.Country;
import org.springframework.stereotype.Repository;


import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CountryDaoDb implements CountryDao{

    public static final String URL = "jdbc:mysql://localhost:3306";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "11";
    public static final String INSERT_COUNTRY = "INSERT INTO country(country_name,country_population," +
            "country_continent,country_gdp) VALUE (?, ?, ?, ?)";
    public static final String SELECT_ALL = "SELECT * FROM country LIMIT 0,20";
    public static final String DELETE_COUNTRY = "DELETE FROM COUNTRY WHERE COUNTRY_ID = ?";
    public static final String SELECT_ALL_CITY_BY_COUNTRY_NAME = "select city_id, city_name, country_name, " +
            "city_capital, city_population from city left join country on(city_country_id = country_ID) " +
            "where country_name Like ";
    public static final String SELECT_CITY_CAPITAL_BY_COUNTRY_NAME = "select city_id, city_name, country_name, " +
            "city_capital, city_population from city left join country on(city_country_id = country_ID) " +
            "where city_capital = 1 and country_name Like ";


    private Statement statement = null;
    private Connection connection = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    @Override
    public void addCountry(Country country) throws SQLException {

        driverInstance();

        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            preparedStatement = connection.prepareStatement(INSERT_COUNTRY);

            preparedStatement.setString(1, country.getName());
            preparedStatement.setInt(2, country.getPopulation());
            preparedStatement.setString(3, country.getContinent());
            preparedStatement.setInt(4, country.getGdp());

            preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Country> findAllCountry() {
        ArrayList<Country> countryArrayList = new ArrayList<>();

        driverInstance();

        try{
            connectionStatementResultSet(SELECT_ALL);

            while (resultSet.next()){
                int id = resultSet.getInt("country_id");
                String name = resultSet.getString("country_name");
                int population = resultSet.getInt("country_population");
                String continent = resultSet.getString("country_continent");
                int gdp = resultSet.getInt("country_dgp");

                Country country = new Country(id, name, population, continent, gdp);
                countryArrayList.add(country);
            }

            connection.close();
            statement.close();
            resultSet.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return countryArrayList;
    }

    @Override
    public void deleteById(int id) {
        driverInstance();

        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            preparedStatement = connection.prepareStatement(DELETE_COUNTRY);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<City> getAllCityByCountryName(String country) {

        List<City> cityList = new ArrayList<>();

        driverInstance();

        try{
            connectionStatementResultSet(SELECT_ALL_CITY_BY_COUNTRY_NAME + "'%" + country + "%'");

            while (resultSet.next()){
                int id = resultSet.getInt("city_id");
                String name = resultSet.getString("city_name");
                String country_name = resultSet.getString("country_name");
                boolean capital = resultSet.getBoolean("city_capital");
                int population = resultSet.getInt("city_population");


                City city = new City(id, name, country_name, capital, population);
                cityList.add(city);
            }

            connection.close();
            statement.close();
            resultSet.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        
        return cityList;
    }

    @Override
    public City getCapitalByCountryName(String country) {

        City city = null;

        driverInstance();

        try{
            connectionStatementResultSet(SELECT_CITY_CAPITAL_BY_COUNTRY_NAME + "'%" + country + "%'");

            int id = resultSet.getInt("city_id");
            String name = resultSet.getString("city_name");
            String country_name = resultSet.getString("country_name");
            boolean capital = resultSet.getBoolean("city_capital");
            int population = resultSet.getInt("city_population");

            city = new City(id, name, country_name, capital, population);


            connection.close();
            statement.close();
            resultSet.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return city;
    }

    private void driverInstance() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException
                | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void connectionStatementResultSet(String textSql) throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        statement = connection.createStatement();

        resultSet = statement.executeQuery(textSql);
    }
}
