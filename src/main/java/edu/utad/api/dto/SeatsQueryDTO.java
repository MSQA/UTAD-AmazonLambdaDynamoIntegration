package edu.utad.api.dto;

import java.io.Serializable;

public class SeatsQueryDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private String roomName;

  public String getRoomName() {
    return roomName;
  }

  public void setRoomName(String roomName) {
    this.roomName = roomName;
  }

}
