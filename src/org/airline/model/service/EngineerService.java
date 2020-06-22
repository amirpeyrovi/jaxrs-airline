package org.airline.model.service;

import org.airline.model.entity.Engineer;
import org.airline.model.repository.EngineerDA;

import java.util.List;

public class EngineerService {
    private static EngineerService ourInstance = new EngineerService();

    private EngineerService() {
    }

    public static EngineerService getInstance(){
        return ourInstance;
    }

    public void save(Engineer engineer) throws Exception {
        try (EngineerDA engineerDA = new EngineerDA()) {
            engineerDA.insert(engineer);
        }
    }

    public void update(Engineer engineer) throws Exception {
        try (EngineerDA engineerDA = new EngineerDA()) {
            engineerDA.update(engineer);
        }
    }

    public void delete(Engineer engineer) throws Exception {
        try (EngineerDA engineerDA = new EngineerDA()) {
            engineerDA.delete(engineer);
        }
    }

    public Engineer findOne(Engineer engineer) throws Exception {
        try (EngineerDA engineerDA = new EngineerDA()) {
            return engineerDA.selectOne(engineer);
        }
    }

    public Engineer findOneById(Integer id) throws Exception {
        try (EngineerDA engineerDA = new EngineerDA()) {
            return engineerDA.selectOneById(id);
        }
    }

    public List<Engineer> findAll() throws Exception {
        try (EngineerDA engineerDA = new EngineerDA()) {
            return engineerDA.selectAll();
        }
    }
}
