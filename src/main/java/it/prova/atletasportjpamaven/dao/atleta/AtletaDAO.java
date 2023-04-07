package it.prova.atletasportjpamaven.dao.atleta;

import it.prova.atletasportjpamaven.dao.IBaseDAO;
import it.prova.atletasportjpamaven.model.Atleta;

public interface AtletaDAO extends IBaseDAO<Atleta>{

	public void disconnectAtletaToSport(Atleta atletaInput);
	
	public void deleteAndDisconnectAtleta(Atleta atletaInput);
}
