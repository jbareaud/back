package fr.sfeir.back.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.sfeir.back.dao.QuartierRepository;
import fr.sfeir.back.entities.Quartier;

@Service
@Transactional
public class QuartierService implements IQuartierService {

	@Autowired
	private QuartierRepository repository;
	
	public Quartier fetch(long id) {
		return repository.findOne(id);
	}

	public Quartier update(Quartier quartier) {
		return repository.save(quartier);
	}

	public void delete(long id) {
		repository.delete(id);
	}
	
	public Quartier create(Quartier quartier) {
		return repository.save(quartier);
	}
	
	public List<Quartier> all() {
		return repository.findAll();
	}
	
}
