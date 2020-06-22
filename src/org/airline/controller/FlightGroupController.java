package org.airline.controller;

import org.airline.model.entity.Certificate;
import org.airline.model.entity.FlightGroup;
import org.airline.model.service.CertificateService;
import org.airline.model.service.FlightGroupService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.HashMap;
import java.util.Map;

@Path("/flightGroup")
public class FlightGroupController {
    @Path("/save")
    @GET
    @Produces("application/json")
    public Object save(@QueryParam("id") String id, @QueryParam("groupName") String groupName, @QueryParam("groupCode") String groupCode, @QueryParam("flightTime") String flightTime, @QueryParam("flightCount") String flightCount, @QueryParam("pilot") String pilot, @QueryParam("pilotAssistant") String pilotAssistant, @QueryParam("hosts") String hosts, @QueryParam("engineer") String engineer){
        FlightGroup flightGroup = new FlightGroup(Integer.parseInt(id), groupName, groupCode, Integer.parseInt(flightTime), Integer.parseInt(flightCount), Integer.parseInt(pilot), Integer.parseInt(pilotAssistant), Integer.parseInt(hosts), Integer.parseInt(engineer));
        try {
            FlightGroupService.getInstance().save(flightGroup);
            return FlightGroupService.getInstance().findOne(flightGroup);
        }catch (Exception e){
            Map map = new HashMap();
            map.put("error", e.getMessage());
            return map;
        }
    }

    @Path("/update")
    @GET
    @Produces("application/json")
    public Object update(@QueryParam("id") String id, @QueryParam("groupName") String groupName, @QueryParam("groupCode") String groupCode, @QueryParam("flightTime") String flightTime, @QueryParam("flightCount") String flightCount, @QueryParam("pilot") String pilot, @QueryParam("pilotAssistant") String pilotAssistant, @QueryParam("hosts") String hosts, @QueryParam("engineer") String engineer) {
        FlightGroup flightGroup = new FlightGroup(Integer.parseInt(id), groupName, groupCode, Integer.parseInt(flightTime), Integer.parseInt(flightCount), Integer.parseInt(pilot), Integer.parseInt(pilotAssistant), Integer.parseInt(hosts), Integer.parseInt(engineer));
        try {
            FlightGroupService.getInstance().update(flightGroup);
            return FlightGroupService.getInstance().findOne(flightGroup);
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
        FlightGroup flightGroup = new FlightGroup(Integer.parseInt(id));
        try {
            FlightGroupService.getInstance().delete(flightGroup);
            return FlightGroupService.getInstance().findAll();
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
            return FlightGroupService.getInstance().findAll();
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
        FlightGroup flightGroup = new FlightGroup(Integer.parseInt(id));
        try {
            return FlightGroupService.getInstance().findOne(flightGroup);
        } catch (Exception e) {
            Map map = new HashMap();
            map.put("error", e.getMessage());
            return map;
        }
    }
}
