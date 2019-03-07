package br.com.fiap.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.SearchNotFoundException;

public abstract class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	private EntityManager em;

	
	
	
	//ATRIBUTO PRO METODO READ
	//
		private Class<T> clazz;
		
		
		
	// construtor cheio
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		super();
		this.em = em;
		this.clazz= (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	

		
		
	// METODOS
	@Override
	public void create(T table) {
		em.persist(table);
	}

	@Override
	public T read(K key) throws SearchNotFoundException {
		T entity = em.find(clazz, key);
		//VERIFICA SE VALIDA
		if (entity == null) {
			throw new SearchNotFoundException();
		}
		return entity;
	}

	@Override
	public void update(T table) {
		em.merge(table);
	}

	@Override
	public void delete(K key) throws SearchNotFoundException {
		//PESQUISA no metodo read
		T entity = read(key);

		//REMOVE
		em.remove(entity);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}

	}

}
