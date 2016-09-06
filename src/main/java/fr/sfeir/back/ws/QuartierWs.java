package fr.sfeir.back.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.sfeir.back.entities.Quartier;
import fr.sfeir.back.services.QuartierService;

@RestController
@RequestMapping("/quartiers")
public class QuartierWs {

	@Autowired
	private QuartierService service;

	@RequestMapping(method = RequestMethod.GET)
	public Quartier select(@RequestParam(value = "id", defaultValue = "1") String idQuartier) {
		return service.fetch(Long.parseLong(idQuartier));
	}

	@RequestMapping(method = RequestMethod.POST)
	public void update(@RequestBody Quartier quartier) { 
		service.update(quartier);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void create(@RequestBody Quartier quartier) {
		service.create(quartier);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "id", defaultValue = "1") String idQuartier) {
		service.delete(Long.parseLong(idQuartier));
	}

}
