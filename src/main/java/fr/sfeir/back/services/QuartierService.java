package fr.sfeir.back.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.sfeir.back.dao.QuartierDao;
import fr.sfeir.back.entities.Quartier;

@Service
@Transactional
public class QuartierService {

	@Autowired
	private QuartierDao dao;
	
	public Quartier fetch(long id) {
		return dao.fetch(id);
	}

	public Quartier update(Quartier quartier) {
		return dao.update(quartier);
	}

	public void delete(long id) {
		dao.delete(id);
	}
	
	public Quartier create(Quartier quartier) {
		return dao.create(quartier);
	}
	
	public List<Quartier> all() {
		return dao.all();
	}
	
}
