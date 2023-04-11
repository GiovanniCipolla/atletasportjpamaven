package it.prova.atletasportjpamaven.dao.atleta;

import it.prova.atletasportjpamaven.dao.IBaseDAO;
import it.prova.atletasportjpamaven.model.Atleta;
import it.prova.atletasportjpamaven.model.Sport;

//interfaccia dove estedndiamo ibasedao e inseriamo metodi specifici per questa entità.
public interface AtletaDAO extends IBaseDAO<Atleta>{

	//da fare override nel daoimpl
	public int sumNumeroMedaglieVinteInSportChiusi() throws Exception;
}
