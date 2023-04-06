package it.prova.atletasportjpamaven.service.sport;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.atletasportjpamaven.dao.EntityManagerUtil;
import it.prova.atletasportjpamaven.dao.atleta.AtletaDAO;
import it.prova.atletasportjpamaven.dao.sport.SportDAO;
import it.prova.atletasportjpamaven.model.Atleta;
import it.prova.atletasportjpamaven.model.Sport;

public class SportServiceImpl implements SportService {

	private SportDAO sportDAO;
	private AtletaDAO atletaDAO;

	@Override
	public void setSportDAO(SportDAO sportDAO) {
		this.sportDAO = sportDAO;
	}

	@Override
	public void setAtletaDAO(AtletaDAO atletaDAO) {
		this.atletaDAO = atletaDAO;
	}

	@Override
	public List<Sport> lista() throws Exception {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			sportDAO.setEntityManager(entityManager);

			return sportDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Sport leggi(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			
			sportDAO.setEntityManager(entityManager);
			
			return sportDAO.get(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Sport sportInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			sportDAO.setEntityManager(entityManager);
			
			sportDAO.update(sportInstance);
			
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
	public void inserisci(Sport sportInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			sportDAO.setEntityManager(entityManager);
			sportDAO.insert(sportInstance);
			
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
	public void rimuovi(Sport sportInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			sportDAO.setEntityManager(entityManager);
			
			sportDAO.delete(sportInstance);
			
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}
}
