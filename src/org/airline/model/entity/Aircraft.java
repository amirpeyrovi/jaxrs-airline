package org.airline.model.entity;

public class Aircraft {
    private Integer id;
    private String company;
    private String vendor;
    private String model;
    private Integer certificate;
    private Integer flightTime;
    private Integer flightCount;
    private Integer flightMaxTime;
    private Integer flightMaxCount;

    public Aircraft() {
    }

    public Aircraft(Integer id, String company, String vendor, String model, Integer certificate, Integer flightTime, Integer flightCount, Integer flightMaxTime, Integer flightMaxCount) {
        this.id = id;
        this.company = company;
        this.vendor = vendor;
        this.model = model;
        this.certificate = certificate;
        this.flightTime = flightTime;
        this.flightCount = flightCount;
        this.flightMaxTime = flightMaxTime;
        this.flightMaxCount = flightMaxCount;
    }

    public Aircraft(int parseInt) {
    }

    public Integer getId() {
        return id;
    }

    public Aircraft setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public Aircraft setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getVendor() {
        return vendor;
    }

    public Aircraft setVendor(String vendor) {
        this.vendor = vendor;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Aircraft setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getCertificate() {
        return certificate;
    }

    public Aircraft setCertificate(Integer certificate) {
        this.certificate = certificate;
        return this;
    }

    public Integer getFlightTime() {
        return flightTime;
    }

    public Aircraft setFlightTime(Integer flightTime) {
        this.flightTime = flightTime;
        return this;
    }

    public Integer getFlightCount() {
        return flightCount;
    }

    public Aircraft setFlightCount(Integer flightCount) {
        this.flightCount = flightCount;
        return this;
    }

    public Integer getFlightMaxTime() {
        return flightMaxTime;
    }

    public Aircraft setFlightMaxTime(Integer flightMaxTime) {
        this.flightMaxTime = flightMaxTime;
        return this;
    }

    public Integer getFlightMaxCount() {
        return flightMaxCount;
    }

    public Aircraft setFlightMaxCount(Integer flightMaxCount) {
        this.flightMaxCount = flightMaxCount;
        return this;
    }
}

// table structure: CREATE TABLE aircraft (id number, company varchar2(32), vendor varchar2(32), model varchar2(32), certificate number, flightTime number, flightCount number, flightMaxTime number, flightMaxCount number)
