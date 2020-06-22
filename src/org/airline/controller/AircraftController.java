package org.airline.controller;

import org.airline.model.entity.Aircraft;
import org.airline.model.service.AircraftService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.HashMap;
import java.util.Map;

@Path("/aircraft")
public class AircraftController {
    @Path("/save")
    @GET
    @Produces("application/json")
    public Object save(@QueryParam("id") String id, @QueryParam("company") String company, @QueryParam("vendor") String vendor, @QueryParam("model") String model, @QueryParam("certificate") String certificate, @QueryParam("flightTime") String flightTime, @QueryParam("flightCount") String flightCount, @QueryParam("flightMaxTime") String flightMaxTime, @QueryParam("flightMaxCount") String flightMaxCount){
        Aircraft aircraft = new Aircraft(Integer.parseInt(id), company, vendor, model, Integer.parseInt(certificate), Integer.parseInt(flightTime), Integer.parseInt(flightCount), Integer.parseInt(flightMaxTime), Integer.parseInt(flightMaxCount));
        try {
            AircraftService.getInstance().save(aircraft);
            return AircraftService.getInstance().findOne(aircraft);
        }catch (Exception e){
            Map map = new HashMap();
            map.put("error", e.getMessage());
            return map;
        }
    }

    @Path("/update")
    @GET
    @Produces("application/json")
    public Object update(@QueryParam("id") String id, @QueryParam("company") String company, @QueryParam("vendor") String vendor, @QueryParam("model") String model, @QueryParam("certificate") String certificate, @QueryParam("flightTime") String flightTime, @QueryParam("flightCount") String flightCount, @QueryParam("flightMaxTime") String flightMaxTime, @QueryParam("flightMaxCount") String flightMaxCount) {
        Aircraft aircraft = new Aircraft(Integer.parseInt(id), company, vendor, model, Integer.parseInt(certificate), Integer.parseInt(flightTime), Integer.parseInt(flightCount), Integer.parseInt(flightMaxTime), Integer.parseInt(flightMaxCount));
        try {
            AircraftService.getInstance().update(aircraft);
            return AircraftService.getInstance().findOne(aircraft);
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
        Aircraft aircraft = new Aircraft(Integer.parseInt(id));
        try {
            AircraftService.getInstance().delete(aircraft);
            return AircraftService.getInstance().findAll();
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
            return AircraftService.getInstance().findAll();
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
        Aircraft aircraft = new Aircraft(Integer.parseInt(id));
        try {
            return AircraftService.getInstance().findOne(aircraft);
        } catch (Exception e) {
            Map map = new HashMap();
            map.put("error", e.getMessage());
            return map;
        }
    }
}
