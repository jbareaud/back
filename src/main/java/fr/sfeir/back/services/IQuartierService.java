package fr.sfeir.back.services;

import java.util.List;

import fr.sfeir.back.entities.Quartier;

public interface IQuartierService {

	Quartier fetch(long id);

	Quartier update(Quartier quartier);

	void delete(long id);
	
	Quartier create(Quartier quartier);
	
	List<Quartier> all();

}