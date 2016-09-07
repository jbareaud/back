package fr.sfeir.back;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import fr.sfeir.back.ws.QuartierWs;

@Configuration
//@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(QuartierWs.class);	
	}
}
