package edu.utad.api.jetty;

import org.glassfish.jersey.server.ResourceConfig;

import edu.utad.api.resources.BookResource;
import edu.utad.api.resources.HealthCheck;
import edu.utad.api.resources.ManagerSeatsResource;
import edu.utad.api.resources.SeatResources;

public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
      //register(BookResource.class);
      //register(ManagerSeatsResource.class);
      register(HealthCheck.class);
      register(SeatResources.class);
    }
    
}