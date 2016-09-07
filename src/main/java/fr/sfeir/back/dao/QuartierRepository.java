package fr.sfeir.back.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.sfeir.back.entities.Quartier;

public interface QuartierRepository extends JpaRepository<Quartier, Long> {

	/**
	 * Retourne les quartiers possédant un nom particulier.
	 * @param nom
	 * @return
	 */
    List<Quartier> findByNom(String nom);

}
