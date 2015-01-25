package edu.utad.api.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.amazonaws.services.lambda.model.InvokeAsyncRequest;
import com.amazonaws.services.lambda.model.InvokeAsyncResult;

import edu.utad.api.amazon.connector.AWSLambdaAsyncClientConnector;
import edu.utad.api.dao.SeatsDao;
import edu.utad.api.model.Seats;
import edu.utad.api.services.SeatManager;

@Named
public class SeatManagerImpl implements SeatManager{

  @Inject
  private SeatsDao seatsDao;
  
  @Inject
  private AWSLambdaAsyncClientConnector AWSLambdaAsyncClientConnector;
  
  @Override
  public boolean createRoom(int cols, int rows, String roomName) {
    for(int i = 0; i < rows; i++){
      for(int j = 0; j < cols; j++){
        seatsDao.createSeat(i, j, roomName);
      }
    }
    return true;
    
  }

  @Override
  public boolean bookSeat(String seatId, Long version, String ownerName) {
    seatsDao.bookSeat(seatId, version, ownerName);
    
    InvokeAsyncRequest invokeAsyncRequest = new InvokeAsyncRequest();
    invokeAsyncRequest.setFunctionName("OregonTest");
    invokeAsyncRequest.setInvokeArgs("{\"seatId\":\""+seatId+"\",\"status\":\"approved\"}");
    
    InvokeAsyncResult invokeAsyncResult = AWSLambdaAsyncClientConnector.getLamdba().invokeAsync(invokeAsyncRequest);
    int status = invokeAsyncResult.getStatus().intValue();

    return true;
  }

  @Override
  public List<Seats> getSeatsByRoomName(String roomName) {
    return seatsDao.getSeatsByRoomName(roomName);
  }

}
