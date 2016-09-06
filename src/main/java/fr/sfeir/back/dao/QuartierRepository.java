package fr.sfeir.back.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.sfeir.back.entities.Quartier;

public interface QuartierRepository extends JpaRepository<Quartier, Long> {

}
