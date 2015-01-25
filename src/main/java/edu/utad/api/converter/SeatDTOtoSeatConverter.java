package edu.utad.api.converter;

import org.springframework.core.convert.converter.Converter;

import edu.utad.api.dto.SeatsDTO;
import edu.utad.api.model.Seats;

public class SeatDTOtoSeatConverter implements Converter<SeatsDTO, Seats> {

  @Override
  public Seats convert(SeatsDTO seatDTO) {
    Seats seat = new Seats();
    seat.setStatus(seatDTO.getStatus());
    seat.setId(seatDTO.getId());
    seat.setRoomName(seatDTO.getRoomName());
    seat.setCol(seatDTO.getCol());
    seat.setRow(seatDTO.getRow());
    seat.setOwnerName(seatDTO.getOwnerName());
    return seat;
  }

}
