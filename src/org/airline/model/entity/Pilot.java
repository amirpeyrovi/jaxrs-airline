package org.airline.model.entity;

public class Pilot {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer salary;
    private Integer flightTime;
    private Integer flightCount;
    private Integer certificate;
    private static final Integer type = 0;

    public Pilot() {
    }

    public Pilot(Integer id, String firstName, String lastName, Integer age, Integer salary, Integer flightTime, Integer flightCount, Integer certificate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.flightTime = flightTime;
        this.flightCount = flightCount;
        this.certificate = certificate;
    }

    public Pilot(int parseInt) {
    }

    public Integer getId() {
        return id;
    }

    public Pilot setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Pilot setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Pilot setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Pilot setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Integer getSalary() {
        return salary;
    }

    public Pilot setSalary(Integer salary) {
        this.salary = salary;
        return this;
    }

    public Integer getFlightTime() {
        return flightTime;
    }

    public Pilot setFlightTime(Integer flightTime) {
        this.flightTime = flightTime;
        return this;
    }

    public Integer getFlightCount() {
        return flightCount;
    }

    public Pilot setFlightCount(Integer flightCount) {
        this.flightCount = flightCount;
        return this;
    }

    public Integer getCertificate() {
        return certificate;
    }

    public Pilot setCertificate(Integer certificate) {
        this.certificate = certificate;
        return this;
    }

    public static Integer getType() {
        return type;
    }
}
