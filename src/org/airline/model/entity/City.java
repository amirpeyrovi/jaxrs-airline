package org.airline.model.entity;

public class City {
    private Integer id;
    private String name;
    private Integer latitude;
    private Integer longitude;

    public City() {
    }

    public City(Integer id, String name, Integer latitude, Integer longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public City(int parseInt) {
    }

    public Integer getId() {
        return id;
    }

    public City setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public City setLatitude(Integer latitude) {
        this.latitude = latitude;
        return this;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public City setLongitude(Integer longitude) {
        this.longitude = longitude;
        return this;
    }
}

//table structure: CREATE TABLE city (id number, name varchar2(32), latitude number, longitude number)
