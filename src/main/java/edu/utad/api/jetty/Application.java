package edu.utad.api.jetty;


import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import edu.utad.api.filter.ApiOriginFilter;


@Configuration
@ImportResource("classpath:utad-context.xml")
@EnableAutoConfiguration
public class Application implements CommandLineRunner{
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Bean
    public ServletRegistrationBean jerseyServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/*");
        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
  
        return registration;
    }

	@Bean
    public FilterRegistrationBean ApiOriginfilterRegistrationBean () {
        ApiOriginFilter apiOriginFilter = new ApiOriginFilter();
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(apiOriginFilter);
        registrationBean.setOrder(0);
        
        return registrationBean;
    }
}
