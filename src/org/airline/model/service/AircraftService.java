package org.airline.model.service;

import org.airline.model.entity.Aircraft;
import org.airline.model.repository.AircraftDA;

import java.util.List;

public class AircraftService {
    private static AircraftService ourInstance = new AircraftService();

    private AircraftService() {
    }

    public static AircraftService getInstance(){
        return ourInstance;
    }

    public void save(Aircraft aircraft) throws Exception {
        try (AircraftDA aircraftDA = new AircraftDA()) {
            aircraftDA.insert(aircraft);
        }
    }

    public void update(Aircraft aircraft) throws Exception {
        try (AircraftDA aircraftDA = new AircraftDA()) {
            aircraftDA.update(aircraft);
        }
    }

    public void delete(Aircraft aircraft) throws Exception {
        try (AircraftDA aircraftDA = new AircraftDA()) {
            aircraftDA.delete(aircraft);
        }
    }

    public Aircraft findOne(Aircraft aircraft) throws Exception {
        try (AircraftDA aircraftDA = new AircraftDA()) {
            return aircraftDA.selectOne(aircraft);
        }
    }

    public Aircraft findOneById(Integer id) throws Exception {
        try (AircraftDA aircraftDA = new AircraftDA()) {
            return aircraftDA.selectOneById(id);
        }
    }

    public List<Aircraft> findAll() throws Exception {
        try (AircraftDA aircraftDA = new AircraftDA()) {
            return aircraftDA.selectAll();
        }
    }

}
