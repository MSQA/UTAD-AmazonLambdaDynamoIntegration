package edu.utad.api.services;

import java.util.List;

import edu.utad.api.model.Seats;

public interface SeatManager {
  
  boolean createRoom(int cols, int rows, String roomName);

  boolean bookSeat(String seatId, Long version, String ownerName);
   
  List<Seats> getSeatsByRoomName(String roomName);
}
