package org.airline.model.service;

import org.airline.model.entity.City;
import org.airline.model.entity.Flight;
import org.airline.model.repository.CityDA;
import org.airline.model.repository.FlightDA;

import java.util.List;

public class FlightService {
    private static FlightService ourInstance = new FlightService();

    private FlightService() {
    }

    public static FlightService getInstance(){
        return ourInstance;
    }

    public void save(Flight flight) throws Exception {
        try (FlightDA flightDA = new FlightDA()) {
            flightDA.insert(flight);
        }
    }

    public void update(Flight flight) throws Exception {
        try (FlightDA flightDA = new FlightDA()) {
            flightDA.update(flight);
        }
    }

    public void delete(Flight flight) throws Exception {
        try (FlightDA flightDA = new FlightDA()) {
            flightDA.delete(flight);
        }
    }

    public Flight findOne(Flight flight) throws Exception {
        try (FlightDA flightDA = new FlightDA()) {
            return flightDA.selectOne(flight);
        }
    }

    public Flight findOneById(Integer id) throws Exception {
        try (FlightDA flightDA = new FlightDA()) {
            return flightDA.selectOneById(id);
        }
    }

    public List<Flight> findAll() throws Exception {
        try (FlightDA flightDA = new FlightDA()) {
            return flightDA.selectAll();
        }
    }
}
