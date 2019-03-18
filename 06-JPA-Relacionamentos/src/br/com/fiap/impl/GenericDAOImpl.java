package br.com.fiap.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;

public abstract class GenericDAOImpl <T, K> implements GenericDAO<T,K>{

	
		private EntityManager em;
		
		
		//Pega o .class da tabela utilizada
		private Class<T> clazz;  
		
		
		
		@SuppressWarnings("unchecked")
		public GenericDAOImpl(EntityManager em) {
			this.em = em;
			this.clazz=(Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
		
		
		
		@Override
		public void create (T table) {
			em.persist(table);
		}
		
		
		@Override
		public T read(K key) throws IdNotFoundException {
			T entity = em.find(clazz, key);
			
			if(entity==null) {
				throw new IdNotFoundException();
				
			}
			return entity;
		}
		
		
		@Override
		public void update(T table) {
			em.merge(table);
		}
		
		@Override
		public void delete (K key) throws IdNotFoundException{
			T entity = read (key);
			
			em.remove(entity);
		}
		
		@Override
		public void commit() throws CommitException{
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
