package fr.sfeir.back.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.sfeir.back.entities.Quartier;

@Service
@Transactional
public interface IQuartierService {

	Quartier fetch(long id);

	Quartier update(Quartier quartier);

	void delete(long id);
	
	Quartier create(Quartier quartier);
	
	List<Quartier> all();

}