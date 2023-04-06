package it.prova.atletasportjpamaven.dao.atleta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import it.prova.atletasportjpamaven.model.Atleta;

public class AtletaDAOImpl implements AtletaDAO{
	
	private EntityManager entityManager;
	
	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	// --------------------------- CRUD ------------------------------
	
	@Override
	public List<Atleta> list() throws Exception {
		return entityManager.createQuery("from Atleta",Atleta.class).getResultList();
	}

	@Override
	public Atleta get(Long id) throws Exception {
		return entityManager.find(Atleta.class, id);
	}

	@Override
	public void update(Atleta atletaInstance) throws Exception {
		if(atletaInstance == null)
			throw new Exception("Problema valore in input");
		atletaInstance = entityManager.merge(atletaInstance);
		
	}

	@Override
	public void insert(Atleta atletaInstance) throws Exception {
		if(atletaInstance == null)
			throw new Exception("Problema valore in input");
		entityManager.persist(atletaInstance);
		
	}

	@Override
	public void delete(Atleta atletaInstance) throws Exception {
		if(atletaInstance == null)
			throw new Exception("Problema valore in input");
		entityManager.remove(entityManager.merge(atletaInstance));
	}


}
