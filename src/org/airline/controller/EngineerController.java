package org.airline.controller;

import org.airline.model.entity.City;
import org.airline.model.entity.Engineer;
import org.airline.model.service.AircraftService;
import org.airline.model.service.CityService;
import org.airline.model.service.EngineerService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.HashMap;
import java.util.Map;

@Path("/engineer")
public class EngineerController {
    @Path("/save")
    @GET
    @Produces("application/json")
    public Object save(@QueryParam("id") String id, @QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName, @QueryParam("age") String age, @QueryParam("salary") String salary, @QueryParam("flightTime") String flightTime, @QueryParam("flightCount") String flightCount){
        Engineer engineer = new Engineer(Integer.parseInt(id), firstName, lastName, Integer.parseInt(age), Integer.parseInt(salary), Integer.parseInt(flightTime), Integer.parseInt(flightCount));
        try {
            EngineerService.getInstance().save(engineer);
            return EngineerService.getInstance().findOne(engineer);
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
        Engineer engineer = new Engineer(Integer.parseInt(id), firstName, lastName, Integer.parseInt(age), Integer.parseInt(salary), Integer.parseInt(flightTime), Integer.parseInt(flightCount));
        try {
            EngineerService.getInstance().update(engineer);
            return EngineerService.getInstance().findOne(engineer);
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
        Engineer engineer = new Engineer(Integer.parseInt(id));
        try {
            EngineerService.getInstance().delete(engineer);
            return EngineerService.getInstance().findAll();
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
            return EngineerService.getInstance().findAll();
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
        Engineer engineer = new Engineer(Integer.parseInt(id));
        try {
            return EngineerService.getInstance().findOne(engineer);
        } catch (Exception e) {
            Map map = new HashMap();
            map.put("error", e.getMessage());
            return map;
        }
    }
}
