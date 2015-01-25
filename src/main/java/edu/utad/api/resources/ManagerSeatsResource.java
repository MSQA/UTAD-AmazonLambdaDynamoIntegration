package edu.utad.api.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import edu.utad.api.dto.RoomDTO;
import edu.utad.api.service.impl.SeatManagerImpl;


@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ManagerSeatsResource {
  
  public final static String URLBASE = "/management";
  
  @Inject
  private SeatManagerImpl seatManager;

  @POST
  @Path("/room")
  public Response createRoom(@PathParam("version") String version,RoomDTO roomDTO) {
  
    seatManager.createRoom(roomDTO.getCols(), roomDTO.getRows(), roomDTO.getRoomName());
    
    return Response.noContent().build();
  }

}
