package it.prova.atletasportjpamaven.dao.atleta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mysql.cj.Query;

import it.prova.atletasportjpamaven.model.Atleta;
import it.prova.atletasportjpamaven.model.Sport;
// classe che implementa la sua interfaccia
public class AtletaDAOImpl implements AtletaDAO {

	//istanziamo una variabile di tipo EntityManager. inerente sempre alla connesione
	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	// --------------------------- CRUD ------------------------------

	//  IMPLEMENTAZIONE DEI METODI CRUD sempre sull' istanza entity manager, collegata al database
	
	// lista 
	@Override
	public List<Atleta> list() throws Exception {
		return entityManager.createQuery("from Atleta", Atleta.class).getResultList();
	}

	// read, lettura.. usiamo find con id
	@Override
	public Atleta get(Long id) throws Exception {
		return entityManager.find(Atleta.class, id);
	}

	// update, aggiorna. usiamo persist.
	@Override
	public void update(Atleta atletaInstance) throws Exception {
		if (atletaInstance == null)
			throw new Exception("Problema valore in input");
		atletaInstance = entityManager.merge(atletaInstance);

	}
	
	@Override
	public void insert(Atleta atletaInstance) throws Exception {
		if (atletaInstance == null)
			throw new Exception("Problema valore in input");

		entityManager.persist(atletaInstance);

	}

	@Override
	public void delete(Atleta atletaInstance) throws Exception {
		if (atletaInstance == null)
			throw new Exception("Problema valore in input");
		entityManager.remove(entityManager.merge(atletaInstance));
	}

	// somma del numero di medaglie vinte in sport con data finita-
	public int sumNumeroMedaglieVinteInSportChiusi() throws Exception {
		TypedQuery<Long> query = entityManager.createQuery(
				"SELECT SUM(a.numeroMedaglieVinte) FROM Atleta a JOIN a.sports s WHERE s.dataFine IS NOT NULL",
				Long.class);
		
		Long sum = query.getSingleResult();
		
		//intValue() restituisce il valore assoluto!!0
		int result = sum != null ? sum.intValue() : 0;
		
		return result;
	}

}
