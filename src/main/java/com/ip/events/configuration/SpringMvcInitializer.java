package com.ip.events.configuration;

import com.ip.events.configuration.EventsConfiguration;
import com.ip.springsecurity.configuration.SecurityConfiguration;
import org.springframework.security.access.SecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SecurityConfiguration.class, ApplicationConfig.class };
	}
 
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { EventsConfiguration.class };
	}
 
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
