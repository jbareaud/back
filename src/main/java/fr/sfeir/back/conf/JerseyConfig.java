package fr.sfeir.back.conf;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import fr.sfeir.back.webservices.QuartierWs;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {

		// http://localhost:8080/swagger.json

		register(CorsFilter.class);
		register(SwaggerSerializers.class);
		register(ApiListingResource.class);
		register(QuartierWs.class);
		
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("v1");
		beanConfig.setSchemes(new String[] { "http" });
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("/");
		beanConfig.setResourcePackage("fr.sfeir.back");
		beanConfig.setPrettyPrint(true);
		beanConfig.setScan(true);
	}
}
