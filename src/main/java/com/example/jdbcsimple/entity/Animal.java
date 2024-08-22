package com.example.jdbcsimple.entity;

public class Animal {
    private long id;
    private String name;
    // getters/setters/constructors


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal() {
    }

    public Animal(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Animal(String name) {
        this.id = 0;
        this.name = name;
    }
}