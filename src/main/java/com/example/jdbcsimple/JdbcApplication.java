package com.example.jdbcsimple;

import com.example.jdbcsimple.entity.Animal;

import java.sql.*;

public class JdbcApplication {

    public static void main(String[] args) {

        Animal byId = findById(1);
        System.out.println(byId);

    }

    public static Animal findById(long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "Girashi1");
            statement = connection.prepareStatement(
                    "select id, name from animal where id=?");
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            Animal animal = null;
            if (resultSet.next()) {
                animal = new Animal(
                        resultSet.getLong("id"),
                        resultSet.getString("name"));
            }
            return animal;
        } catch (SQLException e) {
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }
        return null;

    }


}


