package org.airline.controller;

import org.airline.model.entity.Aircraft;
import org.airline.model.entity.Certificate;
import org.airline.model.service.AircraftService;
import org.airline.model.service.CertificateService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.HashMap;
import java.util.Map;

@Path("/certificate")
public class CertificateController {
    @Path("/save")
    @GET
    @Produces("application/json")
    public Object save(@QueryParam("id") String id, @QueryParam("name") String name, @QueryParam("code") String code){
        Certificate certificate = new Certificate(Integer.parseInt(id), name, code);
        try {
            CertificateService.getInstance().save(certificate);
            return CertificateService.getInstance().findOne(certificate);
        }catch (Exception e){
            Map map = new HashMap();
            map.put("error", e.getMessage());
            return map;
        }
    }

    @Path("/update")
    @GET
    @Produces("application/json")
    public Object update(@QueryParam("id") String id, @QueryParam("name") String name, @QueryParam("code") String code) {
        Certificate certificate = new Certificate(Integer.parseInt(id), name, code);
        try {
            CertificateService.getInstance().update(certificate);
            return CertificateService.getInstance().findOne(certificate);
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
        Certificate certificate = new Certificate(Integer.parseInt(id));
        try {
            CertificateService.getInstance().delete(certificate);
            return CertificateService.getInstance().findAll();
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
            return CertificateService.getInstance().findAll();
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
        Certificate certificate = new Certificate(Integer.parseInt(id));
        try {
            return CertificateService.getInstance().findOne(certificate);
        } catch (Exception e) {
            Map map = new HashMap();
            map.put("error", e.getMessage());
            return map;
        }
    }
}
