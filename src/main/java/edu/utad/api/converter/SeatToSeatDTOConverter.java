package edu.utad.api.converter;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import edu.utad.api.dto.SeatsDTO;
import edu.utad.api.model.Seats;

public class SeatToSeatDTOConverter  implements Converter<Seats, SeatsDTO>{

  @Override
  public SeatsDTO convert(Seats seats) {
    SeatsDTO seatsDTO = new SeatsDTO();
    seatsDTO.setId(seats.getId());
    seatsDTO.setCreatedAt(new Date(seats.getCreatedAt()));
    seatsDTO.setUpdatedAt(new Date(seats.getUpdatedAt()));
    seatsDTO.setStatus(seats.getStatus());
    seatsDTO.setRoomName(seats.getRoomName());
    seatsDTO.setCol(seats.getCol());
    seatsDTO.setRow(seats.getRow());
    seatsDTO.setOwnerName(seats.getOwnerName());
    seatsDTO.setVersion(seats.getVersion());
    
    return seatsDTO;
  }

}
