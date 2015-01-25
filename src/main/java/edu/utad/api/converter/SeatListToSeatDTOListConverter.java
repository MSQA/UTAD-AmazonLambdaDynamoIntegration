package edu.utad.api.converter;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.core.convert.converter.Converter;

import edu.utad.api.dto.SeatsDTO;
import edu.utad.api.model.Seats;

public class SeatListToSeatDTOListConverter  implements Converter<Collection<Seats>, Collection<SeatsDTO>>{

  private SeatToSeatDTOConverter seatToSeatDTOConverter = new SeatToSeatDTOConverter();
  
  @Override
  public Collection<SeatsDTO> convert(Collection<Seats> seatsList) {
    
    Collection<SeatsDTO> seatsDTOlist = new ArrayList<SeatsDTO>();
    
    for(Seats s: seatsList){
      seatsDTOlist.add(seatToSeatDTOConverter.convert(s)); 
    }
    
    return seatsDTOlist;
  }

 
}
