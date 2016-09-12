package fr.sfeir.back.webservices;

import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import fr.sfeir.back.db.entities.Quartier;
import fr.sfeir.back.services.IQuartierService;
import fr.sfeir.back.webservices.beans.QuartierBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Component
@Path("/quartiers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api("API des quartiers")
public class QuartierWs {

	@Autowired
	private IQuartierService quartierService;

	@Autowired
	private ConversionService conversionService;
	
	@ApiOperation(value = "Récupérer les quartiers")
	@ApiResponses(value = {
		@ApiResponse(code = 200, response = QuartierBean.class, responseContainer = "List",
				message = "Renvoit tous les quartiers connus")
	})
	@GET
	public Response getQuartiers() {
		return Response
				.status(Status.OK)
				.entity(quartierService
						.all()
						.stream()
						.map(quartier -> conversionService.convert(quartier, QuartierBean.class))
						.collect(Collectors.toList())
				)
				.build();
	}

	@ApiOperation(value = "Récupérer un quartier")
	@ApiResponses(value = {
		@ApiResponse(code = 200, response = QuartierBean.class, message = "Quartier trouvé"),
		@ApiResponse(code = 404, message = "Quartier inconnu")
	})
	@GET
	@Path("{quartierId}")
	public Response getQuartier(
			@ApiParam(value = "Id du quartier", required=true) @PathParam("quartierId") Long quartierId) {
		Quartier quartier = quartierService.fetch(quartierId);
		if (quartier != null) {
			return Response
					.status(Status.OK)
					.entity(conversionService.convert(quartier, QuartierBean.class))
					.build();
		}
		return Response
				.status(Status.NOT_FOUND)
				.build();
	}

	@ApiOperation(value = "Créer un quartier")
	@ApiResponses(value = {
		@ApiResponse(code = 200, response = Quartier.class, message = "Quartier créé")
	})
	@POST
	public Response create(Quartier quartier) {
		return Response
				.status(Status.OK)
				.entity(quartierService.create(quartier))
				.build();
	}

	@ApiOperation(value = "MAJ un quartier")
	@ApiResponses(value = {
		@ApiResponse(code = 200, response = Quartier.class, message = "Quartier mis à jour")
	})
	@PUT
	public Response maj(Quartier quartier) {
		return Response
				.status(Status.OK)
				.entity(quartierService.update(quartier))
				.build();
	}
	
	@ApiOperation(value = "Supprimer un quartier")
	@ApiResponses(value = {
		@ApiResponse(code = 204, message = "Quartier supprimé")
	})
	@DELETE
	@Path("{quartierId}")
	public Response delete(
			@ApiParam(value = "Id du quartier", required=true) @PathParam("quartierId") Long quartierId) {
		quartierService.delete(quartierId);
		return Response
				.status(Status.NO_CONTENT)
				.build();
	}

}
