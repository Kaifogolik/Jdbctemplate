package com.example.jdbcproject;

import com.example.jdbcproject.entity.Animal;
import com.example.jdbcproject.repository.AnimalRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;


//@JdbcTest
@RunWith(SpringRunner.class)
//@DataJpaTest
@Import(AnimalRepository.class)
@SpringBootTest(classes = {JdbcProjectApplication.class, JpaConfig.class})
public class AnimalRepositoryTest {

    @Autowired
    AnimalRepository animalRepository;



    @Test
    public void getById() {
        Animal animalById = animalRepository.getById(2);
//        Assertions.assertEquals(2, animalById.getId());

    }

    //Todo протестировать все методы репозитория

    @Test
    public void getByName() {

    }
}