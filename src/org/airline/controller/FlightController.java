package org.airline.controller;

import org.airline.model.entity.Certificate;
import org.airline.model.entity.Flight;
import org.airline.model.service.AircraftService;
import org.airline.model.service.CertificateService;
import org.airline.model.service.FlightService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.HashMap;
import java.util.Map;

@Path("/flight")
public class FlightController {
    @Path("/save")
    @GET
    @Produces("application/json")
    public Object save(@QueryParam("id") String id, @QueryParam("code") String code, @QueryParam("dateTime") String dateTime, @QueryParam("source") String source, @QueryParam("destination") String destination, @QueryParam("flightGroup") String flightGroup, @QueryParam("aircraft") String aircraft){
        Flight flight = new Flight(Integer.parseInt(id), code, dateTime, Integer.parseInt(source), Integer.parseInt(destination), Integer.parseInt(flightGroup), Integer.parseInt(aircraft));
        try {
            FlightService.getInstance().save(flight);
            return FlightService.getInstance().findOne(flight);
        }catch (Exception e){
            Map map = new HashMap();
            map.put("error", e.getMessage());
            return map;
        }
    }

    @Path("/update")
    @GET
    @Produces("application/json")
    public Object update(@QueryParam("id") String id, @QueryParam("code") String code, @QueryParam("dateTime") String dateTime, @QueryParam("source") String source, @QueryParam("destination") String destination, @QueryParam("flightGroup") String flightGroup, @QueryParam("aircraft") String aircraft) {
        Flight flight = new Flight(Integer.parseInt(id), code, dateTime, Integer.parseInt(source), Integer.parseInt(destination), Integer.parseInt(flightGroup), Integer.parseInt(aircraft));
        try {
            FlightService.getInstance().update(flight);
            return FlightService.getInstance().findOne(flight);
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
        Flight flight = new Flight(Integer.parseInt(id));
        try {
            FlightService.getInstance().delete(flight);
            return FlightService.getInstance().findAll();
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
            return FlightService.getInstance().findAll();
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
        Flight flight = new Flight(Integer.parseInt(id));
        try {
            return FlightService.getInstance().findOne(flight);
        } catch (Exception e) {
            Map map = new HashMap();
            map.put("error", e.getMessage());
            return map;
        }
    }
}
