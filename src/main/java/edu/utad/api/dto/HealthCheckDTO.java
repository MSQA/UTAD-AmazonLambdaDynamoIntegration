package edu.utad.api.dto;

import java.io.Serializable;
import java.util.Date;

public class HealthCheckDTO implements Serializable{
  
  private static final long serialVersionUID = -978760362018128334L;
  private String status = "OK";
  private Date currentDate = new Date();
  
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public Date getCurrentDate() {
    return currentDate;
  }
  public void setCurrentDate(Date currentDate) {
    this.currentDate = currentDate;
  }
 
}
