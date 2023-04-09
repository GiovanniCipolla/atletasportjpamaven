package it.prova.atletasportjpamaven.service.atleta;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.atletasportjpamaven.dao.atleta.AtletaDAO;
import it.prova.atletasportjpamaven.dao.sport.SportDAO;
import it.prova.atletasportjpamaven.model.Atleta;
import it.prova.atletasportjpamaven.model.Sport;
import it.prova.atletasportjpamaven.dao.EntityManagerUtil;

public class AtletaServiceImpl implements AtletaService {

	private AtletaDAO atletaDAO;
	private SportDAO sportDAO;

	@Override
	public void setAtletaDAO(AtletaDAO atletaDAO) {
		this.atletaDAO = atletaDAO;
	}

	public void setSportDAO(SportDAO sportDAO) {
		this.sportDAO = sportDAO;
	}

	@Override
	public List<Atleta> lista() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			atletaDAO.setEntityManager(entityManager);

			return atletaDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Atleta leggi(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			
			atletaDAO.setEntityManager(entityManager);
			
			return atletaDAO.get(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

	@Override
	public void aggiorna(Atleta atletaInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			atletaDAO.setEntityManager(entityManager);
			
			
			
			atletaDAO.update(atletaInstance);
			
			
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

	@Override
	public void inserisci(Atleta atletaInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			atletaDAO.setEntityManager(entityManager);
			
			atletaDAO.insert(atletaInstance);
			
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

	@Override
	public void rimuovi(Atleta atletaInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			atletaDAO.setEntityManager(entityManager);
			
			atletaDAO.delete(atletaInstance);
			
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}


	@Override
	public void connettiSportAATleta(Atleta atletaEsistente,Sport sportInstance)throws Exception{
		// apriamo la connessione
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			// iniziamo la transazione
			entityManager.getTransaction().begin();
			
			//inejcton per altetadao
			atletaDAO.setEntityManager(entityManager);
			// facciamo capire che già esiste e non deve essere creato
			atletaEsistente = entityManager.merge(atletaEsistente);
			sportInstance = entityManager.merge(sportInstance);
			
			atletaEsistente.getSports().add(sportInstance);
			
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void scollegaSportDAAtleta(Atleta atletaEsistente, Sport sportInstance) throws Exception {
		// apriamo la connessione
				EntityManager entityManager = EntityManagerUtil.getEntityManager();
				
				try {
					// iniziamo la transazione
					entityManager.getTransaction().begin();
					
					//inejcton per altetadao
					atletaDAO.setEntityManager(entityManager);
					// facciamo capire che già esiste e non deve essere creato
					atletaEsistente = entityManager.merge(atletaEsistente);
					sportInstance = entityManager.merge(sportInstance);
					
					atletaEsistente.getSports().remove(sportInstance);
					
					entityManager.getTransaction().commit();
				} catch (Exception e) {
					entityManager.getTransaction().rollback();
					e.printStackTrace();
					throw e;
				} finally {
					EntityManagerUtil.closeEntityManager(entityManager);
				}
		
	}

	@Override
	public void rimuoviEScollegaAtleta(Atleta atletaEsistente, Sport sportEsistente) throws Exception {
		// apriamo la connessione
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			// iniziamo la transazione
			entityManager.getTransaction().begin();
			
			//inejcton per altetadao
			atletaDAO.setEntityManager(entityManager);
			// facciamo capire che già esiste e non deve essere creato
			atletaEsistente = entityManager.merge(atletaEsistente);
			sportEsistente = entityManager.merge(sportEsistente);
			
			atletaEsistente.getSports().remove(sportEsistente);
			
			atletaDAO.delete(atletaEsistente);
			
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

		
	}

	@Override
	public int contaNumeroMedaglieSportChiusi() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			atletaDAO.setEntityManager(entityManager);
			
			return atletaDAO.sumNumeroMedaglieVinteInSportChiusi();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	
}
