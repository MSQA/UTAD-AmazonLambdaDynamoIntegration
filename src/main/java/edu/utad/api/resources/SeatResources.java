package edu.utad.api.resources;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import edu.utad.api.model.Seats;
import edu.utad.api.service.impl.SeatManagerImpl;


@Path("{version}"+"/seats")
@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SeatResources {


  @Inject
  private SeatManagerImpl seatManager;
  
  @Inject
  private ManagerSeatsResource managerSeatsResource;
  
  @Inject
  private BookResource bookResource;
  
  @Inject
  private ConversionService conversionService;

  @GET
  @Path("/{roomName}")
  public Response getSeats(@PathParam("version") String version, @PathParam("roomName") String roomName) {
  
    List<Seats> seats = seatManager.getSeatsByRoomName(roomName);
    
    return Response.ok(conversionService.convert(seats, Collection.class)).build();
  }
  

  @Path(ManagerSeatsResource.URLBASE)
  public ManagerSeatsResource getManagerSeatsResource() {
    return managerSeatsResource;
  }


  public void setManagerSeatsResource(ManagerSeatsResource managerSeatsResource) {
    this.managerSeatsResource = managerSeatsResource;
  }


  @Path(BookResource.URLBASE)
  public BookResource getBookResource() {
    return bookResource;
  }


  public void setBookResource(BookResource bookResource) {
    this.bookResource = bookResource;
  }
  
}
