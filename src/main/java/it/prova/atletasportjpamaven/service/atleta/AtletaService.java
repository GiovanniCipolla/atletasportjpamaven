package it.prova.atletasportjpamaven.service.atleta;

import java.util.List;

import it.prova.atletasportjpamaven.dao.atleta.AtletaDAO;
import it.prova.atletasportjpamaven.dao.sport.SportDAO;
import it.prova.atletasportjpamaven.model.Atleta;

public interface AtletaService {

	public void setAtletaDAO(AtletaDAO atletaDAO);
	public void setSportDAO(SportDAO sportDAO);
	
	
	public List<Atleta> lista()throws Exception;
	
	public Atleta leggi(Long id)throws Exception;
	
	public void aggiorna(Atleta atletaInstance)throws Exception;
	
	public void inserisci(Atleta atletaInstance) throws Exception;
	
	public void rimuovi(Atleta atletaInstance)throws Exception;
}
