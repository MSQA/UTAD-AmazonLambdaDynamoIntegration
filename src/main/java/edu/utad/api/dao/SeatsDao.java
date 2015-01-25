package edu.utad.api.dao;

import java.util.List;

import edu.utad.api.model.Seats;

public interface SeatsDao {

  boolean createSeat(int col, int row, String roomName);
  
  boolean bookSeat(String seatId, Long version, String ownerName);
  
  List<Seats> getSeatsByRoomName(String roomName);
}
