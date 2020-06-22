package org.airline.model.entity;

public class PilotAssistant {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer salary;
    private Integer flightTime;
    private Integer flightCount;
    private static final Integer certificate = 0;
    private static final Integer type = 1;

    public PilotAssistant(Integer id, String firstName, String lastName, Integer age, Integer salary, Integer flightTime, Integer flightCount) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.flightTime = flightTime;
        this.flightCount = flightCount;
    }

    public PilotAssistant() {
    }

    public PilotAssistant(int parseInt) {
    }

    public Integer getId() {
        return id;
    }

    public PilotAssistant setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public PilotAssistant setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PilotAssistant setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public PilotAssistant setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Integer getSalary() {
        return salary;
    }

    public PilotAssistant setSalary(Integer salary) {
        this.salary = salary;
        return this;
    }

    public Integer getFlightTime() {
        return flightTime;
    }

    public PilotAssistant setFlightTime(Integer flightTime) {
        this.flightTime = flightTime;
        return this;
    }

    public Integer getFlightCount() {
        return flightCount;
    }

    public PilotAssistant setFlightCount(Integer flightCount) {
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
