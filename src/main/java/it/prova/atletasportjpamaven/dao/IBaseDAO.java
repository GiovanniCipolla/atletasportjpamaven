package it.prova.atletasportjpamaven.dao;

import java.util.List;

import javax.persistence.EntityManager;
//interfaccia da cui erediteremo i metodi principali oer il dao , CRUD
// e anche inkection , per dare sempre connesione
public interface IBaseDAO<T> {

	public List<T> list() throws Exception;

	public T get(Long id) throws Exception;

	public void update(T o) throws Exception;

	public void insert(T o) throws Exception;

	public void delete(T o) throws Exception;

	// questo mi serve per l'injection
	public void setEntityManager(EntityManager entityManager);

}
