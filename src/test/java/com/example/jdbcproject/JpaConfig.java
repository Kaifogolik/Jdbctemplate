package com.example.jdbcproject;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableJpaRepositories(basePackages = "com.example.jdbcproject.repository")
@PropertySource("testapplication.properties")
@EnableTransactionManagement
public class JpaConfig {

}