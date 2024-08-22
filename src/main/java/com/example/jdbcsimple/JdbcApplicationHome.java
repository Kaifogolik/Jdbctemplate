package com.example.jdbcsimple;

import com.example.jdbcsimple.entity.Animal;

import java.sql.*;

public class JdbcApplicationHome {

    public static void main(String[] args) {



        insert(new Animal("Caticat"));

    }

    public static Animal findByName(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "Girashi1");
            statement = connection.prepareStatement(
                    "select id, name from animal where name=?");
            statement.setString(1, name);
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

    //TOdo написать аналогичный метод, но для поиска по name - findByName
    //*Todo Вынести  общий код из обоих методов в общий метод - (инициализация Connection)

    //TODO руками написать запросы SQL - найти сущнгсть по ID, найти сущность по Name,
    //TODO update сущность - как делать загуглить
    //TODO delete сущность - как делать загуглить
    //**TODO написать метод который делает delete сущности deleteByID
    //**TODO написать метод который делает update сущности update

    //*TODO прочитать про  автоинкремент что это и зачем
    //*TODO прочитать про  -primarykey и связи таблиц

    public static void insert(Animal animal) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Girashi1");
            String sql = "INSERT INTO animal (name) VALUES (?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, animal.getName());
//            statement.setLong(2, animal.getId());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new animal was inserted successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void update(Animal animal) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "Girashi1");

            String sql = "UPDATE animal SET name = ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, animal.getName());
            statement.setLong(2, animal.getId());

            int rowsAffected = statement.executeUpdate();
            System.out.println("Updated " + rowsAffected + " row(s)");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteById(long id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "Girashi1");

            String sql = "DELETE FROM animal WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Deleted " + rowsAffected + " row(s)");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // переписать 2 метода так чтобы они использовали общий метод
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


