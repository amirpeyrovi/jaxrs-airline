package org.airline.controller;

import org.airline.model.entity.Certificate;
import org.airline.model.entity.Hosts;
import org.airline.model.service.CertificateService;
import org.airline.model.service.HostsService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.HashMap;
import java.util.Map;

@Path("/hosts")
public class HostsController {
    @Path("/save")
    @GET
    @Produces("application/json")
    public Object save(@QueryParam("id") String id, @QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName, @QueryParam("age") String age, @QueryParam("salary") String salary, @QueryParam("flightTime") String flightTime, @QueryParam("flightCount") String flightCount){
        Hosts hosts = new Hosts(Integer.parseInt(id), firstName, lastName, Integer.parseInt(age), Integer.parseInt(salary), Integer.parseInt(flightTime), Integer.parseInt(flightCount));
        try {
            HostsService.getInstance().save(hosts);
            return HostsService.getInstance().findOne(hosts);
        }catch (Exception e){
            Map map = new HashMap();
            map.put("error", e.getMessage());
            return map;
        }
    }

    @Path("/update")
    @GET
    @Produces("application/json")
    public Object update(@QueryParam("id") String id, @QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName, @QueryParam("age") String age, @QueryParam("salary") String salary, @QueryParam("flightTime") String flightTime, @QueryParam("flightCount") String flightCount) {
        Hosts hosts = new Hosts(Integer.parseInt(id), firstName, lastName, Integer.parseInt(age), Integer.parseInt(salary), Integer.parseInt(flightTime), Integer.parseInt(flightCount));
        try {
            HostsService.getInstance().update(hosts);
            return HostsService.getInstance().findOne(hosts);
        }catch (Exception e){
            Map map = new HashMap();
            map.put("error", e.getMessage());
            return map;
        }
    }

    @Path("/delete")
    @GET
    @Produces("application/json")
    public Object delete(@QueryParam("id") String id){
        Hosts hosts = new Hosts(Integer.parseInt(id));
        try {
            HostsService.getInstance().delete(hosts);
            return HostsService.getInstance().findAll();
        }catch (Exception e){
            Map map = new HashMap();
            map.put("error", e.getMessage());
            return map;
        }
    }

    @Path("/findAll")
    @GET
    @Produces("application/json")
    public Object findAll(){
        try {
            return HostsService.getInstance().findAll();
        } catch (Exception e) {
            Map map = new HashMap();
            map.put("error", e.getMessage());
            return map;
        }
    }

    @Path("/findOne")
    @GET
    @Produces("application/json")
    public Object findOne(@QueryParam("id") String id) {
        Hosts hosts = new Hosts(Integer.parseInt(id));
        try {
            return HostsService.getInstance().findOne(hosts);
        } catch (Exception e) {
            Map map = new HashMap();
            map.put("error", e.getMessage());
            return map;
        }
    }
}
