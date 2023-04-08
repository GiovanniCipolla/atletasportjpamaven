package it.prova.atletasportjpamaven.dao.sport;

import java.util.List;

import it.prova.atletasportjpamaven.dao.IBaseDAO;
import it.prova.atletasportjpamaven.model.Atleta;
import it.prova.atletasportjpamaven.model.Sport;

public interface SportDAO extends IBaseDAO<Sport> {

	
	
	public List<Sport> errorDate() throws Exception;
}
