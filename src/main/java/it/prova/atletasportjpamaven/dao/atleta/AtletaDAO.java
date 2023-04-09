package it.prova.atletasportjpamaven.dao.atleta;

import it.prova.atletasportjpamaven.dao.IBaseDAO;
import it.prova.atletasportjpamaven.model.Atleta;
import it.prova.atletasportjpamaven.model.Sport;

public interface AtletaDAO extends IBaseDAO<Atleta>{

	
	public int sumNumeroMedaglieVinteInSportChiusi() throws Exception;
}
