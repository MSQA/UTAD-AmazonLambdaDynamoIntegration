package edu.utad.api.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import edu.utad.api.dto.HealthCheckDTO;

@Path("{version}"+"/healthCheck")
@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HealthCheck {

  @GET
  public Response getUser(@PathParam("version") String version) {
 
    HealthCheckDTO healthCheckDTO = new HealthCheckDTO();
    return Response.ok(healthCheckDTO).build();
  }

}
