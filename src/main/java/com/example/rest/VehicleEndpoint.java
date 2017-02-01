package com.example.rest;

import com.example.models.Vehicle;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1.0/vehicles")
@ApplicationScoped
public class VehicleEndpoint {

  @PersistenceContext
  EntityManager em;

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Vehicle[] all() {
    return em.createNamedQuery("Vehicle.findAll", Vehicle.class)
        .getResultList()
        .toArray(new Vehicle[0]);
  }

  @GET
  @Path("/{vehicleno}")
  @Produces(MediaType.APPLICATION_JSON)
  public Vehicle get(@PathParam("vehicleno") int vehicleno){
    return em.createNamedQuery("Vehicle.find", Vehicle.class)
        .setParameter("vehicleno", vehicleno)
        .getResultList()
        .get(0);

  }

  @POST
  @Path("/new")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public Vehicle post(Vehicle vehicle){
    em.persist(vehicle);
    return get(vehicle.getVehicleno());
  }
  
  @PUT
  @Path("/{vehicleno}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public Vehicle put(@PathParam("vehicleno") int vehicleno, Vehicle vehicle){
    em.merge(vehicle);    
    return get(vehicle.getVehicleno());
  }
}
