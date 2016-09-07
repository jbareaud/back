package fr.sfeir.back.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.sfeir.back.entities.Quartier;
import fr.sfeir.back.services.QuartierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Component
@Path("/quartiers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(consumes = "application/json", produces = "application/json", protocols = "http")
public class QuartierWs {

	@Autowired
	private QuartierService service;

	@ApiOperation(value = "Récupérer les quartiers", httpMethod = "GET")
	@GET
	public Response getQuartiers() {
		return Response
				.status(Status.OK)
				.entity(service.all())
				.build();
	}

	@ApiOperation(value = "Récupérer les quartiers", httpMethod = "GET")
	@GET
	@Path("{quartierId}")
	public Response getQuartier(@PathParam("quartierId") String quartierId) {
		if (!StringUtils.isEmpty(quartierId)) {
			return Response
					.status(Status.OK)
					.entity(service.fetch(Long.parseLong(quartierId)))
					.build();
		}
		return Response
				.status(Status.NO_CONTENT)
				.build();
	}

	@ApiOperation(value = "Créer un quartier", httpMethod = "POST")
	@POST
	public Response create(Quartier quartier) {
		System.out.println(quartier);
		return Response
				.status(Status.OK)
				.entity(service.create(quartier))
				.build();
	}

	@ApiOperation(value = "Supprimer un quartier", httpMethod = "DELETE")
	@DELETE
	@Path("{quartierId}")
	public Response delete(@PathParam("quartierId") String quartierId) {
		if (!StringUtils.isEmpty(quartierId)) {
			service.delete(Long.parseLong(quartierId));
		}
		return Response
				.status(Status.ACCEPTED)
				.build();
	}

}
