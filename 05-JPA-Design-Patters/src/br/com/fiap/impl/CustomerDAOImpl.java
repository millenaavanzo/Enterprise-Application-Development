package br.com.fiap.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CustomerDAO;
import br.com.fiap.entity.Customer;

public class CustomerDAOImpl extends GenericDAOImpl<Customer, Integer> implements CustomerDAO {

	public CustomerDAOImpl(EntityManager em) {
		super(em);
	}

	
}
