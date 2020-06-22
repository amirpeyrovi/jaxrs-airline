package org.airline.controller;

import org.airline.model.entity.Hosts;
import org.airline.model.entity.Pilot;
import org.airline.model.service.HostsService;
import org.airline.model.service.PilotService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.HashMap;
import java.util.Map;

@Path("/pilot")
public class PilotController {
    @Path("/save")
    @GET
    @Produces("application/json")
    public Object save(@QueryParam("id") String id, @QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName, @QueryParam("age") String age, @QueryParam("salary") String salary, @QueryParam("flightTime") String flightTime, @QueryParam("flightCount") String flightCount, @QueryParam("certificate") String certificate){
        Pilot pilot = new Pilot(Integer.parseInt(id), firstName, lastName, Integer.parseInt(age), Integer.parseInt(salary), Integer.parseInt(flightTime), Integer.parseInt(flightCount), Integer.parseInt(certificate));
        try {
            PilotService.getInstance().save(pilot);
            return PilotService.getInstance().findOne(pilot);
        }catch (Exception e){
            Map map = new HashMap();
            map.put("error", e.getMessage());
            return map;
        }
    }

    @Path("/update")
    @GET
    @Produces("application/json")
    public Object update(@QueryParam("id") String id, @QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName, @QueryParam("age") String age, @QueryParam("salary") String salary, @QueryParam("flightTime") String flightTime, @QueryParam("flightCount") String flightCount, @QueryParam("certificate") String certificate) {
        Pilot pilot = new Pilot(Integer.parseInt(id), firstName, lastName, Integer.parseInt(age), Integer.parseInt(salary), Integer.parseInt(flightTime), Integer.parseInt(flightCount), Integer.parseInt(certificate));
        try {
            PilotService.getInstance().update(pilot);
            return PilotService.getInstance().findOne(pilot);
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
        Pilot pilot = new Pilot(Integer.parseInt(id));
        try {
            PilotService.getInstance().delete(pilot);
            return PilotService.getInstance().findAll();
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
            return PilotService.getInstance().findAll();
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
        Pilot pilot = new Pilot(Integer.parseInt(id));
        try {
            return PilotService.getInstance().findOne(pilot);
        } catch (Exception e) {
            Map map = new HashMap();
            map.put("error", e.getMessage());
            return map;
        }
    }
}
