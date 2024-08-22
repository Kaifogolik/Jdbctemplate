package com.example.jdbcproject.repository;

import com.example.jdbcproject.entity.Animal;
import com.example.jdbcproject.mapper.AnimalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AnimalRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    //Todo рассказать
    @Transactional
    public Animal getById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbcTemplate.queryForObject("select * from animal where id=:id", params, new AnimalMapper());
    }

    @Transactional
    public Animal getByName(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return jdbcTemplate.queryForObject("select * from animal where name=:name", params, new AnimalMapper());
    }

    @Transactional
    public List<Animal> getAll() {
        return jdbcTemplate.query("select * from animal", new AnimalMapper());
    }

    @Transactional
    public void save(Animal animal) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", animal.getName());
        String sql = "INSERT INTO animal (name) VALUES (:name)";
        jdbcTemplate.update(sql, params);
    }

    //TOdo реализовать методы delete и update
}