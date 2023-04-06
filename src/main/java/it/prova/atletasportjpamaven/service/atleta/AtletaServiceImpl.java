package it.prova.atletasportjpamaven.service.atleta;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.atletasportjpamaven.dao.atleta.AtletaDAO;
import it.prova.atletasportjpamaven.dao.sport.SportDAO;
import it.prova.atletasportjpamaven.model.Atleta;
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

}
