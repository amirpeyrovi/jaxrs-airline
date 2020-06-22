package org.airline.model.entity;

public class Hosts {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer salary;
    private Integer flightTime;
    private Integer flightCount;
    private static final Integer certificate = 0;
    private static final Integer type = 2;

    public Hosts() {
    }

    public Hosts(Integer id, String firstName, String lastName, Integer age, Integer salary, Integer flightTime, Integer flightCount) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.flightTime = flightTime;
        this.flightCount = flightCount;
    }

    public Hosts(int parseInt) {
    }

    public Integer getId() {
        return id;
    }

    public Hosts setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Hosts setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Hosts setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Hosts setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Integer getSalary() {
        return salary;
    }

    public Hosts setSalary(Integer salary) {
        this.salary = salary;
        return this;
    }

    public Integer getFlightTime() {
        return flightTime;
    }

    public Hosts setFlightTime(Integer flightTime) {
        this.flightTime = flightTime;
        return this;
    }

    public Integer getFlightCount() {
        return flightCount;
    }

    public Hosts setFlightCount(Integer flightCount) {
        this.flightCount = flightCount;
        return this;
    }

    public static Integer getCertificate() {
        return certificate;
    }

    public static Integer getType() {
        return type;
    }
}
