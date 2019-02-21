package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ImovelDAO;
import br.com.fiap.entity.Imovel;
import br.com.fiap.excecao.CommitException;

public class ImovelDAOImpl implements ImovelDAO {

	private EntityManager em;

	// construtor cheio porque nao pode dar nulo
	public ImovelDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	public void cadastrar(Imovel imovel) {
		em.persist(imovel);
	}

	public Imovel consultar(int codigo) {
		return em.find(Imovel.class, codigo);
	}

	public void atualizar(Imovel imovel) {
		em.merge(imovel);
	}

	public void remover(int codigo) {
		Imovel imovel = consultar(codigo);
		em.remove(imovel);
	}

	// METODO PRA FAZER COMMIT
	public void commit() throws CommitException{
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
			
		}
	}
}
