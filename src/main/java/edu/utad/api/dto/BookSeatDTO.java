package edu.utad.api.dto;

import java.io.Serializable;

public class BookSeatDTO implements Serializable{

  private static final long serialVersionUID = 1L;
  
  private String seatId;
  
  private String ownerName;
  
  private Long version;

  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  public String getSeatId() {
    return seatId;
  }

  public void setSeatId(String seatId) {
    this.seatId = seatId;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

}
