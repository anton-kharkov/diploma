package com.src.dao;

import com.src.domain.Human;
import org.springframework.stereotype.Repository;


import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HumanDaoDb implements HumanDao{

    private String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/diploma";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "11";
    public static final String INSERT_HUMAN = "INSERT INTO human(human_first_name, human_last_name, human_patronymic," +
            "human_year_of_birth, human_inn, human_city_id, human_gender) VALUE (?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_ALL = "select human_id, human_first_name, human_last_name, " +
            "human_patronymic, human_year_of_birth, human_inn, city_name, human_gender " +
            "from human left join city on(human_city_id = city_id) LIMIT 0,20";
    public static final String DELETE_HUMAN = "DELETE FROM HUMAN WHERE HUMAN_ID = ?";

    private Statement statement = null;
    private Connection connection = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    @Override
    public void addHuman(Human human) {
        driverInstance();

        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            preparedStatement = connection.prepareStatement(INSERT_HUMAN);

            preparedStatement.setString(1, human.getFirstName());
            preparedStatement.setString(2, human.getLastName());
            preparedStatement.setString(3, human.getPatronymic());
            preparedStatement.setInt(4, human.getYearOfBirth());
            preparedStatement.setInt(5, human.getInn());
            preparedStatement.setString(6, human.getCountry());
            preparedStatement.setString(7, human.getGender());

            preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Human> findAllHuman() {
        List<Human> humansList = new ArrayList<>();

        driverInstance();

        try{
            connectionStatementResultSet(SELECT_ALL);

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

    @Override
    public void deleteById(int id) {
        driverInstance();

        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            preparedStatement = connection.prepareStatement(DELETE_HUMAN);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void driverInstance() {
        try {
            Class.forName(MYSQL_DRIVER).getDeclaredConstructor().newInstance();
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

