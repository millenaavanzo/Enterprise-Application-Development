package br.com.fiap.dao;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;


public interface GenericDAO <T, K>{
	
	
	void create (T entity);
	
	T read (K id) throws IdNotFoundException;
	
	void update (T entity);
	
	void delete(K id) throws IdNotFoundException;
	
	void commit() throws CommitException;
	

}
