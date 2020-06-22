package org.airline.model.service;

import org.airline.model.entity.Pilot;
import org.airline.model.repository.PilotDA;

import java.util.List;

public class PilotService {
    private static PilotService ourInstance = new PilotService();

    private PilotService() {
    }

    public static PilotService getInstance(){
        return ourInstance;
    }

    public void save(Pilot pilot) throws Exception {
        try (PilotDA pilotDA = new PilotDA()) {
            pilotDA.insert(pilot);
        }
    }

    public void update(Pilot pilot) throws Exception {
        try (PilotDA pilotDA = new PilotDA()) {
            pilotDA.update(pilot);
        }
    }

    public void delete(Pilot pilot) throws Exception {
        try (PilotDA pilotDA = new PilotDA()) {
            pilotDA.delete(pilot);
        }
    }

    public Pilot findOne(Pilot pilot) throws Exception {
        try (PilotDA pilotDA = new PilotDA()) {
            return pilotDA.selectOne(pilot);
        }
    }

    public Pilot findOneById(Integer id) throws Exception {
        try (PilotDA pilotDA = new PilotDA()) {
            return pilotDA.selectOneById(id);
        }
    }

    public List<Pilot> findAll() throws Exception {
        try (PilotDA pilotDA = new PilotDA()) {
            return pilotDA.selectAll();
        }
    }
}
