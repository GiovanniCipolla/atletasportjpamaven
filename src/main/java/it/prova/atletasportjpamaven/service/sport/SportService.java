package it.prova.atletasportjpamaven.service.sport;

import java.util.List;

import it.prova.atletasportjpamaven.dao.atleta.AtletaDAO;
import it.prova.atletasportjpamaven.dao.sport.SportDAO;
import it.prova.atletasportjpamaven.model.Atleta;
import it.prova.atletasportjpamaven.model.Sport;

public interface SportService {

	public void setAtletaDAO(AtletaDAO atletaDAO);

	public void setSportDAO(SportDAO sportDAO);

	public List<Sport> lista() throws Exception;

	public Sport leggi(Long id) throws Exception;

	public void aggiorna(Sport sportInstance) throws Exception;

	public void inserisci(Sport sportInstance) throws Exception;

	public void rimuovi(Sport sportInstance) throws Exception;

	public List<Sport> erroriNelleDate() throws Exception;
}
