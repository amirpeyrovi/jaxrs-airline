package org.airline.model.entity;

public class FlightGroup {
    private Integer id;
    private String groupName;
    private String groupCode;
    private Integer flightTime;
    private Integer flightCount;
    private Integer pilot;
    private Integer pilotAssistant;
    private Integer hosts;
    private Integer engineer;

    public FlightGroup() {
    }

    public FlightGroup(Integer id, String groupName, String groupCode, Integer flightTime, Integer flightCount, Integer pilot, Integer pilotAssistant, Integer hosts, Integer engineer) {
        this.id = id;
        this.groupName = groupName;
        this.groupCode = groupCode;
        this.flightTime = flightTime;
        this.flightCount = flightCount;
        this.pilot = pilot;
        this.pilotAssistant = pilotAssistant;
        this.hosts = hosts;
        this.engineer = engineer;
    }

    public FlightGroup(int parseInt) {
    }

    public Integer getId() {
        return id;
    }

    public FlightGroup setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getGroupName() {
        return groupName;
    }

    public FlightGroup setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public FlightGroup setGroupCode(String groupCode) {
        this.groupCode = groupCode;
        return this;
    }

    public Integer getFlightTime() {
        return flightTime;
    }

    public FlightGroup setFlightTime(Integer flightTime) {
        this.flightTime = flightTime;
        return this;
    }

    public Integer getFlightCount() {
        return flightCount;
    }

    public FlightGroup setFlightCount(Integer flightCount) {
        this.flightCount = flightCount;
        return this;
    }

    public Integer getPilot() {
        return pilot;
    }

    public FlightGroup setPilot(Integer pilot) {
        this.pilot = pilot;
        return this;
    }

    public Integer getPilotAssistant() {
        return pilotAssistant;
    }

    public FlightGroup setPilotAssistant(Integer pilotAssistant) {
        this.pilotAssistant = pilotAssistant;
        return this;
    }

    public Integer getHosts() {
        return hosts;
    }

    public FlightGroup setHosts(Integer hosts) {
        this.hosts = hosts;
        return this;
    }

    public Integer getEngineer() {

        return engineer;
    }

    public FlightGroup setEngineer(Integer engineer) {
        this.engineer = engineer;
        return this;
    }
}

// table structure: CREATE TABLE flightgroup (id number, groupName varchar2(32), groupCode varchar2(32), flightTime number, flightCount number, pilot number, pilotAssistant number, hosts number, engineer  number)
