package edu.utad.api.resources;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;

import edu.utad.api.dto.BookSeatDTO;
import edu.utad.api.service.impl.SeatManagerImpl;

@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
  
  public final static String URLBASE = "/book";
  
  @Inject
  private SeatManagerImpl seatManager;
  
  @PUT
  public Response bookSeats(@PathParam("version") String version, @Valid BookSeatDTO bookSeatDTO) {
  
    try{
      seatManager.bookSeat(bookSeatDTO.getSeatId(), bookSeatDTO.getVersion(), bookSeatDTO.getOwnerName());
    
    }catch(ConditionalCheckFailedException e){
      return Response.status(Status.CONFLICT).entity("{'error':'"+e.getMessage()+"'}").build();
    }
    
    return Response.noContent().build();
  }
 

}
