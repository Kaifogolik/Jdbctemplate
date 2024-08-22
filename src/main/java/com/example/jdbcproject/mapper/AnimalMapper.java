package com.example.jdbcproject.mapper;

import com.example.jdbcproject.entity.Animal;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnimalMapper implements RowMapper<Animal> {
    @Override
    public Animal mapRow(ResultSet resultSet, int i) throws SQLException {
        final int id = resultSet.getInt("id");
        final String name = resultSet.getString("name");
        return new Animal(id, name);
    }
}