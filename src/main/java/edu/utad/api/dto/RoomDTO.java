package edu.utad.api.dto;

import java.io.Serializable;

public class RoomDTO implements Serializable{

  private static final long serialVersionUID = 1L;
  
  private int rows;
  private int cols;
  private String roomName;
  
  public int getRows() {
    return rows;
  }
  public void setRows(int rows) {
    this.rows = rows;
  }
  public int getCols() {
    return cols;
  }
  public void setCols(int cols) {
    this.cols = cols;
  }
  public String getRoomName() {
    return roomName;
  }
  public void setRoomName(String roomName) {
    this.roomName = roomName;
  }

}
