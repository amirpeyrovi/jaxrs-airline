package org.airline.controller;

import org.airline.model.entity.Hosts;
import org.airline.model.entity.PilotAssistant;
import org.airline.model.service.HostsService;
import org.airline.model.service.PilotAssistantService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.HashMap;
import java.util.Map;

@Path("/pilotAssistant")
public class PilotAssistantController {
    @Path("/save")
    @GET
    @Produces("application/json")
    public Object save(@QueryParam("id") String id, @QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName, @QueryParam("age") String age, @QueryParam("salary") String salary, @QueryParam("flightTime") String flightTime, @QueryParam("flightCount") String flightCount){
        PilotAssistant pilotAssistant = new PilotAssistant(Integer.parseInt(id), firstName, lastName, Integer.parseInt(age), Integer.parseInt(salary), Integer.parseInt(flightTime), Integer.parseInt(flightCount));
        try {
            PilotAssistantService.getInstance().save(pilotAssistant);
            return PilotAssistantService.getInstance().findOne(pilotAssistant);
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
        PilotAssistant pilotAssistant = new PilotAssistant(Integer.parseInt(id), firstName, lastName, Integer.parseInt(age), Integer.parseInt(salary), Integer.parseInt(flightTime), Integer.parseInt(flightCount));
        try {
            PilotAssistantService.getInstance().update(pilotAssistant);
            return PilotAssistantService.getInstance().findOne(pilotAssistant);
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
        PilotAssistant pilotAssistant = new PilotAssistant(Integer.parseInt(id));
        try {
            PilotAssistantService.getInstance().delete(pilotAssistant);
            return PilotAssistantService.getInstance().findAll();
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
            return PilotAssistantService.getInstance().findAll();
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
        PilotAssistant pilotAssistant = new PilotAssistant(Integer.parseInt(id));
        try {
            return PilotAssistantService.getInstance().findOne(pilotAssistant);
        } catch (Exception e) {
            Map map = new HashMap();
            map.put("error", e.getMessage());
            return map;
        }
    }
}
