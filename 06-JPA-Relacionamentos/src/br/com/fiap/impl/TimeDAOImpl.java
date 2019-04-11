
package br.com.fiap.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.TimeDAO;
import br.com.fiap.entity.Time;

public class TimeDAOImpl extends GenericDAOImpl<Time, Integer> implements TimeDAO{

	public TimeDAOImpl(EntityManager em) {
		super(em);
	}

}