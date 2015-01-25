package edu.utad.api.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;

import edu.utad.api.amazon.connector.AWSDynamoDBClientConnector;
import edu.utad.api.dao.SeatsDao;
import edu.utad.api.model.Seats;
import edu.utad.api.model.SeatsStatus;

@Named
public class SeatsDaoImpl implements SeatsDao{

 private static final Logger LOG = LoggerFactory.getLogger(SeatsDaoImpl.class);
 
  @Inject
  private AWSDynamoDBClientConnector AWSDynamoDBClientConnector;
  
  @Override
  public boolean createSeat(int col, int row, String roomName) {
    Seats seat = new Seats();
    Date d = new Date();
    seat.setCol(col);
    seat.setRow(row);
    seat.setCreatedAt(d.getTime());
    seat.setUpdatedAt(d.getTime());
    seat.setStatus(SeatsStatus.AVAILABLE.getCode());
    seat.setRoomName(roomName);
    
    AWSDynamoDBClientConnector.getDynamoDBMapper().save(seat);
    return true;
  }

  @Override
  public boolean bookSeat(String seatId, Long version, String ownerName) {
    
    Seats seat = AWSDynamoDBClientConnector.getDynamoDBMapper().load(Seats.class, seatId);
    Date d = new Date();
    seat.setUpdatedAt(d.getTime());
    seat.setStatus(SeatsStatus.PENDING.getCode());
    seat.setOwnerName(ownerName);
    seat.setVersion(version);
    
    AWSDynamoDBClientConnector.getDynamoDBMapper().save(seat);
    
    return true;
  }

  @Override
  public List<Seats> getSeatsByRoomName(String roomName) {
    
    DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
    
    Map<String, Condition> scanFilter = new HashMap<String, Condition>();
    Condition scanCondition = new Condition().withComparisonOperator(ComparisonOperator.EQ).withAttributeValueList(new AttributeValue().withS(roomName));
    scanFilter.put("roomName", scanCondition);
    scanExpression.setScanFilter(scanFilter);
    
    return AWSDynamoDBClientConnector.getDynamoDBMapper().scan(Seats.class, scanExpression);
  }
  
}
