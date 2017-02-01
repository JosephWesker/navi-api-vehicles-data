package com.example.rest;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/")
public class StatusEndpoint {

  @GET
  @Produces("text/plain")
  public Response get() {
    return Response.ok("API Ready!").build();
  }

}
