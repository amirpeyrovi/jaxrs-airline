package org.airline.model.service;

import org.airline.model.entity.FlightGroup;
import org.airline.model.repository.FlightGroupDA;

import java.util.List;

public class FlightGroupService {
    private static FlightGroupService ourInstance = new FlightGroupService();

    private FlightGroupService() {
    }

    public static FlightGroupService getInstance(){
        return ourInstance;
    }

    public void save(FlightGroup flightGroup) throws Exception {
        try (FlightGroupDA flightGroupDA = new FlightGroupDA()) {
            flightGroupDA.insert(flightGroup);
        }
    }

    public void update(FlightGroup flightGroup) throws Exception {
        try (FlightGroupDA flightGroupDA = new FlightGroupDA()) {
            flightGroupDA.update(flightGroup);
        }
    }

    public void delete(FlightGroup flightGroup) throws Exception {
        try (FlightGroupDA flightGroupDA = new FlightGroupDA()) {
            flightGroupDA.delete(flightGroup);
        }
    }

    public FlightGroup findOne(FlightGroup flightGroup) throws Exception {
        try (FlightGroupDA flightGroupDA = new FlightGroupDA()) {
            return flightGroupDA.selectOne(flightGroup);
        }
    }

    public FlightGroup findOneById(Integer id) throws Exception {
        try (FlightGroupDA flightGroupDA = new FlightGroupDA()) {
            return flightGroupDA.selectOneById(id);
        }
    }

    public List<FlightGroup> findAll() throws Exception {
        try (FlightGroupDA flightGroupDA = new FlightGroupDA()) {
            return flightGroupDA.selectAll();
        }
    }
}
