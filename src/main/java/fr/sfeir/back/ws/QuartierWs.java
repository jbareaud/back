package fr.sfeir.back.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.sfeir.back.entities.Quartier;
import fr.sfeir.back.services.QuartierService;

@RestController
public class QuartierWs {
	
	@Autowired
	private QuartierService service;

    @RequestMapping("/select")
    public Quartier select(@RequestParam(value="name", defaultValue="World") String name) {
    	return service.fetch(1);
    }

    @RequestMapping("/update")
    public Quartier maj() {
    	Quartier q = new Quartier(1, "to", null);
    	return service.update(q);
    }
    
    @RequestMapping("/create")
    public Quartier create() {
    	
    	int size = service.all().size();
    	
    	Quartier q = new Quartier();
    	q.setId( size + 1 );
    	q.setNom("foo " + (size + 1) );
    	return service.create(q);
    }
    
    @RequestMapping("/delete")
    public void delete() {
    	service.delete(3);
    }
    
}
