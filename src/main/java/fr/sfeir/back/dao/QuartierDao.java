package fr.sfeir.back.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.sfeir.back.entities.Quartier;

@Repository
public class QuartierDao {

	@Autowired
	private SessionFactory _sessionFactory;

	private Session getSession() {
		return _sessionFactory.getCurrentSession();
	}

	public Quartier fetch(long id) {
		Query query = getSession().createQuery("from Quartier q where q.id=:id");
		query.setParameter("id", id);
		Quartier q = (Quartier) query.list().get(0);
		return q;
	}

	public Quartier update(Quartier quartier) {
		String hqlUpdate = "update Quartier q set q.nom = :newName where q.id = :id";
		int updatedEntities = getSession().createQuery( hqlUpdate )
		        .setString( "newName", quartier.getNom() )
		        .setParameter( "id", quartier.getId() )
		        .executeUpdate();
		return fetch(quartier.getId());
	}

	public void delete(long id) {
		Query query = getSession().createQuery("delete Quartier where id = :id");
		query.setParameter("id", id);
		int i = query.executeUpdate();
		if (i != 1) {
			throw new RuntimeException("Opération delete KO");
		}
	}
	
	public Quartier create(Quartier quartier) {
		getSession().merge(quartier);
		return fetch(quartier.getId());
	}
	
	public List<Quartier> all() {
		return getSession().createQuery("from Quartier").list();
	}

}
