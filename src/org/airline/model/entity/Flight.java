package org.airline.model.entity;

public class Flight {
    private Integer id;
    private String code;
    private String dateTime;
    private Integer source;
    private Integer destination;
    private Integer flightGroup;
    private Integer aircraft;

    public Flight() {
    }

    public Flight(Integer id, String code, String dateTime, Integer source, Integer destination, Integer flightGroup, Integer aircraft) {
        this.id = id;
        this.code = code;
        this.dateTime = dateTime;
        this.source = source;
        this.destination = destination;
        this.flightGroup = flightGroup;
        this.aircraft = aircraft;
    }

    public Flight(int parseInt) {
    }

    public Integer getId() {
        return id;
    }

    public Flight setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Flight setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDateTime() {
        return dateTime;
    }

    public Flight setDateTime(String dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public Integer getSource() {
        return source;
    }

    public Flight setSource(Integer source) {
        this.source = source;
        return this;
    }

    public Integer getDestination() {
        return destination;
    }

    public Flight setDestination(Integer destination) {
        this.destination = destination;
        return this;
    }

    public Integer getFlightGroup() {
        return flightGroup;
    }

    public Flight setFlightGroup(Integer flightGroup) {
        this.flightGroup = flightGroup;
        return this;
    }

    public Integer getAircraft() {
        return aircraft;
    }

    public Flight setAircraft(Integer aircraft) {
        this.aircraft = aircraft;
        return this;
    }
}
//table structure: CREATE TABLE flight (id number, code varchar2(32), dateTime varchar2(32), source number, destination number, flightGroup number, aircraft number)
