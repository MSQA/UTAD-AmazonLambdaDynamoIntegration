package edu.utad.api.dto;

import java.io.Serializable;
import java.util.Date;

public class SeatsDTO implements Serializable{

  private static final long serialVersionUID = 9125521662241229037L;

  private String id;
  private String status;
  private String roomName;
  private Long version;
  private int col;
  private int row;
  private Date createdAt = new Date();
  private Date updatedAt = new Date();
  private String ownerName;
  
  
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public Date getCreatedAt() {
    return createdAt;
  }
  
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }
  
  public Date getUpdatedAt() {
    return updatedAt;
  }
  
  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }
  
  public String getStatus() {
    return status;
  }
  
  public void setStatus(String status) {
    this.status = status;
  }

  public String getRoomName() {
    return roomName;
  }

  public void setRoomName(String roomName) {
    this.roomName = roomName;
  }

  public int getCol() {
    return col;
  }

  public void setCol(int col) {
    this.col = col;
  }

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
  
}
