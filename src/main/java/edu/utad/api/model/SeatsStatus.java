package edu.utad.api.model;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum SeatsStatus {
  
    OCCUPIED("occupied"),
    PENDING("pending"),
	AVAILABLE("available");
	
	private String type;
	private static final Map<String,SeatsStatus> lookUp = new HashMap<String,SeatsStatus>();
	
	static {
		for(SeatsStatus developerRoles : EnumSet.allOf(SeatsStatus.class))
			lookUp.put(developerRoles.getCode(), developerRoles);
	}
	
	private SeatsStatus(String type){
		this.type = type;
	}
	
	public String getCode(){
		return type;
	}
	
	public static SeatsStatus getType(final String code){
		if (lookUp.containsKey(code))
			return lookUp.get(code);
		throw new IllegalStateException();
	}
};
