package it.prova.atletasportjpamaven.dao;

import it.prova.atletasportjpamaven.dao.atleta.AtletaDAO;
import it.prova.atletasportjpamaven.dao.atleta.AtletaDAOImpl;
import it.prova.atletasportjpamaven.dao.sport.SportDAO;
import it.prova.atletasportjpamaven.dao.sport.SportDAOImpl;

// pattern factory e singleton 
public class MyDAOFactory {
	// per ogni entità dao
	
	private static AtletaDAO ATLETA_DAO_INSTANCE = null;
	private static SportDAO RUOLO_DAO_INSTANCE = null;

	public static AtletaDAO getAtletaDAOInstance() {
		if (ATLETA_DAO_INSTANCE == null)
			ATLETA_DAO_INSTANCE = new AtletaDAOImpl();
		return ATLETA_DAO_INSTANCE;
	}

	public static SportDAO getSportDAOInstance() {
		if (RUOLO_DAO_INSTANCE == null)
			RUOLO_DAO_INSTANCE = new SportDAOImpl();
		return RUOLO_DAO_INSTANCE;
	}
}
