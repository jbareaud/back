package fr.sfeir.back.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.sfeir.back.entities.Quartier;
import fr.sfeir.back.services.QuartierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/quartiers")
@Api
public class QuartierWs {

	@Autowired
	private QuartierService service;

	@ApiOperation(value = "Récupérer les quartiers")
	@ApiImplicitParam(name = "id", value =  "1", required = false)
	@RequestMapping(method = RequestMethod.GET)
	public Quartier select(@RequestParam(value = "id", defaultValue = "1") String idQuartier) {
		return service.fetch(Long.parseLong(idQuartier));
	}

	@ApiOperation(value = "Mettre à jour un quartier")
	@RequestMapping(method = RequestMethod.POST)
	public void update(@RequestBody Quartier quartier) { 
		service.update(quartier);
	}

	@ApiOperation(value = "Créer un quartier")
	@RequestMapping(method = RequestMethod.PUT)
	public void create(@RequestBody Quartier quartier) {
		service.create(quartier);
	}

	@ApiOperation(value = "Supprimer un quartier")
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "id", defaultValue = "1") String idQuartier) {
		service.delete(Long.parseLong(idQuartier));
	}

}
