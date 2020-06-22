package org.airline.model.service;

import org.airline.model.entity.Certificate;
import org.airline.model.entity.City;
import org.airline.model.repository.CertificateDA;
import org.airline.model.repository.CityDA;

import java.util.List;

public class CityService {
    private static CityService ourInstance = new CityService();

    private CityService() {
    }

    public static CityService getInstance(){
        return ourInstance;
    }

    public void save(City city) throws Exception {
        try (CityDA cityDA = new CityDA()) {
            cityDA.insert(city);
        }
    }

    public void update(City city) throws Exception {
        try (CityDA cityDA = new CityDA()) {
            cityDA.update(city);
        }
    }

    public void delete(City city) throws Exception {
        try (CityDA cityDA = new CityDA()) {
            cityDA.delete(city);
        }
    }

    public City findOne(City city) throws Exception {
        try (CityDA cityDA = new CityDA()) {
            return cityDA.selectOne(city);
        }
    }

    public City findOneById(Integer id) throws Exception {
        try (CityDA cityDA = new CityDA()) {
            return cityDA.selectOneById(id);
        }
    }

    public List<City> findAll() throws Exception {
        try (CityDA cityDA = new CityDA()) {
            return cityDA.selectAll();
        }
    }
}
