package fr.sfeir.back.db.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.sfeir.back.db.entities.Quartier;

@Repository
public interface QuartierRepository extends JpaRepository<Quartier, Long> {

	/**
	 * Retourne les quartiers possédant un nom particulier.
	 * @param nom
	 * @return
	 */
    List<Quartier> findByNom(String nom);

}
