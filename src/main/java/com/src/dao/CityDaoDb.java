package com.src.dao;

import com.src.domain.City;
import com.src.domain.Human;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CityDaoDb implements CityDao{

    public static final String URL = "jdbc:mysql://localhost:3306/diploma";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "11";
    public static final String INSERT_CITY = "INSERT INTO city(city_name,city_country_id," +
            "city_capital,city_population) VALUE (?, ?, ?, ?)";
    public static final String SELECT_ALL = "select city_id, city_name, country_name, city_capital, city_population " +
            "from city left join country on(city_country_id = country_ID) LIMIT 0,20";
    public static final String DELETE_CITY = "DELETE FROM CITY WHERE CITY_ID = ?";
    public static final String SELECT_ALL_HUMAN_BY_CITY_NAME = "select human_id, human_first_name, human_last_name, " +
            "human_patronymic, human_year_of_birth, human_inn, city_name, human_gender " +
            "from human left join city on(human_city_id = city_id) where city_name Like ";



    private Statement statement = null;
    private Connection connection = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    @Override
    public void addCity(City city) {

        driverInstance();

        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            preparedStatement = connection.prepareStatement(INSERT_CITY);

            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getCountry());
            preparedStatement.setBoolean(3, city.isCapital());
            preparedStatement.setInt(4, city.getPopulation());

            preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<City> findAllCity() {
        ArrayList<City> cityArrayList = new ArrayList<>();

        driverInstance();

        try{
            connectionStatementResultSet(SELECT_ALL);

            while (resultSet.next()){
                int id = resultSet.getInt("city_id");
                String name = resultSet.getString("city_name");
                String country = resultSet.getString("country_name");
                boolean capital = resultSet.getBoolean("city_capital");
                int population = resultSet.getInt("city_population");

                City city = new City(id, name, country, capital, population);
                cityArrayList.add(city);
            }

            connection.close();
            statement.close();
            resultSet.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return cityArrayList;
    }

    @Override
    public void deleteById(int id) {
        driverInstance();

        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            preparedStatement = connection.prepareStatement(DELETE_CITY);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Human> getAllHumanByCityName(String city) {
        List<Human> humansList = new ArrayList<>();

        driverInstance();

        try{
            connectionStatementResultSet(SELECT_ALL_HUMAN_BY_CITY_NAME + "'%" + city + "%'");

            while (resultSet.next()){
                int id = resultSet.getInt("human_id");
                String first_name = resultSet.getString("human_first_name");
                String last_name = resultSet.getString("human_last_name");
                String patronymic = resultSet.getString("human_patronymic");
                int year_of_birth = resultSet.getInt("human_year_of_birth");
                int inn = resultSet.getInt("human_inn");
                String city_name = resultSet.getString("city_name");
                String gender = resultSet.getString("human_gender");


                Human human = new Human(id, first_name, last_name, patronymic, year_of_birth, inn, city_name, gender);
                humansList.add(human);
            }

            connection.close();
            statement.close();
            resultSet.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return humansList;
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
