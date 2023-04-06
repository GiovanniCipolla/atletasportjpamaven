package it.prova.atletasportjpamaven.dao.sport;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.atletasportjpamaven.model.Atleta;
import it.prova.atletasportjpamaven.model.Sport;

public class SportDAOImpl implements SportDAO{
	
private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	// ---------------------- CRUD -----------------------
	@Override
	public List<Sport> list() throws Exception {
		return entityManager.createQuery("from Sport",Sport.class).getResultList();
	}

	@Override
	public Sport get(Long id) throws Exception {
		return entityManager.find(Sport.class, id);
	}

	@Override
	public void update(Sport sportInstance) throws Exception {
		if(sportInstance == null)
			throw new Exception("Problema valore in input");
		sportInstance = entityManager.merge(sportInstance);
		
	}

	@Override
	public void insert(Sport sportInstance) throws Exception {
		if(sportInstance == null)
			throw new Exception("Problema valore in input");
		entityManager.persist(sportInstance);
		
	}

	@Override
	public void delete(Sport sportInstance) throws Exception {
		if(sportInstance == null)
			throw new Exception("Problema valore in input");
		entityManager.remove(entityManager.merge(sportInstance));
		
	}

}
