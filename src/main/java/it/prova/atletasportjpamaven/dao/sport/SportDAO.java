package it.prova.atletasportjpamaven.dao.sport;

import java.util.List;

import it.prova.atletasportjpamaven.dao.IBaseDAO;
import it.prova.atletasportjpamaven.model.Atleta;
import it.prova.atletasportjpamaven.model.Sport;

//interfaccia dove estedndiamo ibasedao e inseriamo metodi specifici per questa entità.
public interface SportDAO extends IBaseDAO<Sport> {

	//da fare override nel daoimpl
	public List<Sport> errorDate() throws Exception;
}
