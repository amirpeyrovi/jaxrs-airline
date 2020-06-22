package org.airline.controller;

import org.airline.model.entity.Certificate;
import org.airline.model.entity.City;
import org.airline.model.service.AircraftService;
import org.airline.model.service.CertificateService;
import org.airline.model.service.CityService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.HashMap;
import java.util.Map;

@Path("/city")
public class CityController {
    @Path("/save")
    @GET
    @Produces("application/json")
    public Object save(@QueryParam("id") String id, @QueryParam("name") String name, @QueryParam("code") String latitude, @QueryParam("code") String longitude){
        City city = new City(Integer.parseInt(id), name, Integer.parseInt(latitude), Integer.parseInt(longitude));
        try {
            CityService.getInstance().save(city);
            return CityService.getInstance().findOne(city);
        }catch (Exception e){
            Map map = new HashMap();
            map.put("error", e.getMessage());
            return map;
        }
    }

    @Path("/update")
    @GET
    @Produces("application/json")
    public Object update(@QueryParam("id") String id, @QueryParam("name") String name, @QueryParam("code") String latitude, @QueryParam("code") String longitude) {
        City city = new City(Integer.parseInt(id), name, Integer.parseInt(latitude), Integer.parseInt(longitude));
        try {
            CityService.getInstance().update(city);
            return CityService.getInstance().findOne(city);
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
        City city = new City(Integer.parseInt(id));
        try {
            CityService.getInstance().delete(city);
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
            return CityService.getInstance().findAll();
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
        City city = new City(Integer.parseInt(id));
        try {
            return CityService.getInstance().findOne(city);
        } catch (Exception e) {
            Map map = new HashMap();
            map.put("error", e.getMessage());
            return map;
        }
    }
}
