package org.airline.model.service;

import org.airline.model.entity.Hosts;
import org.airline.model.repository.HostsDA;

import java.util.List;

public class HostsService {
    private static HostsService ourInstance = new HostsService();

    private HostsService() {
    }

    public static HostsService getInstance(){
        return ourInstance;
    }

    public void save(Hosts hosts) throws Exception {
        try (HostsDA hostsDA = new HostsDA()) {
            hostsDA.insert(hosts);
        }
    }

    public void update(Hosts hosts) throws Exception {
        try (HostsDA hostsDA = new HostsDA()) {
            hostsDA.update(hosts);
        }
    }

    public void delete(Hosts hosts) throws Exception {
        try (HostsDA hostsDA = new HostsDA()) {
            hostsDA.delete(hosts);
        }
    }

    public Hosts findOne(Hosts hosts) throws Exception {
        try (HostsDA hostsDA = new HostsDA()) {
            return hostsDA.selectOne(hosts);
        }
    }

    public Hosts findOneById(Integer id) throws Exception {
        try (HostsDA hostsDA = new HostsDA()) {
            return hostsDA.selectOneById(id);
        }
    }

    public List<Hosts> findAll() throws Exception {
        try (HostsDA hostsDA = new HostsDA()) {
            return hostsDA.selectAll();
        }
    }
}
