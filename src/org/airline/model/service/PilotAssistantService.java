package org.airline.model.service;

import org.airline.model.entity.PilotAssistant;
import org.airline.model.repository.PilotAssistantDA;

import java.util.List;

public class PilotAssistantService {
    private static PilotAssistantService ourInstance = new PilotAssistantService();

    private PilotAssistantService() {
    }

    public static PilotAssistantService getInstance(){
        return ourInstance;
    }

    public void save(PilotAssistant pilotAssistant) throws Exception {
        try (PilotAssistantDA pilotAssistantDA = new PilotAssistantDA()) {
            pilotAssistantDA.insert(pilotAssistant);
        }
    }

    public void update(PilotAssistant pilotAssistant) throws Exception {
        try (PilotAssistantDA pilotAssistantDA = new PilotAssistantDA()) {
            pilotAssistantDA.update(pilotAssistant);
        }
    }

    public void delete(PilotAssistant pilotAssistant) throws Exception {
        try (PilotAssistantDA pilotAssistantDA = new PilotAssistantDA()) {
            pilotAssistantDA.delete(pilotAssistant);
        }
    }

    public PilotAssistant findOne(PilotAssistant pilotAssistant) throws Exception {
        try (PilotAssistantDA pilotAssistantDA = new PilotAssistantDA()) {
            return pilotAssistantDA.selectOne(pilotAssistant);
        }
    }

    public PilotAssistant findOneById(Integer id) throws Exception {
        try (PilotAssistantDA pilotAssistantDA = new PilotAssistantDA()) {
            return pilotAssistantDA.selectOneById(id);
        }
    }

    public List<PilotAssistant> findAll() throws Exception {
        try (PilotAssistantDA pilotAssistantDA = new PilotAssistantDA()) {
            return pilotAssistantDA.selectAll();
        }
    }
}
