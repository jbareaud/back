package fr.sfeir.back.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.sfeir.back.dao.QuartierRepository;
import fr.sfeir.back.entities.Quartier;

@Service
@Transactional
public class QuartierService {

	@Autowired
	private QuartierRepository repository;
	
	public Quartier fetch(long id) {
		return repository.findOne(id);
	}

	public Quartier update(Quartier quartier) {
		if (repository.exists(Example.of(quartier))) {
			return repository.save(quartier);
		}
		throw new RuntimeException("update impossible");
	}

	public void delete(long id) {
		if (repository.exists(id)) {
			repository.delete(id);
		}
		throw new RuntimeException("delete impossible");
	}
	
	public Quartier create(Quartier quartier) {
		if ( ! repository.exists(Example.of(quartier))) {
			return repository.save(quartier);
		}
		throw new RuntimeException("create impossible");
	}
	
	public List<Quartier> all() {
		return repository.findAll();
	}
	
}
