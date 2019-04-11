package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Reserva;
import br.com.fiap.entity.Transporte;

public class ReservaDAOImpl extends GenericDAOImpl<Reserva,Integer> implements ReservaDAO {

	public ReservaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Reserva> listar(){
		//TypedQuery
		TypedQuery<Reserva> query = em.createQuery("from Reserva",Reserva.class);
	return query.getResultList();
	}

	@Override
	public List<Reserva> buscarPorNumeroDias(int dias) {
		TypedQuery<Reserva> query = em.createQuery("from Reserva r where r.numeroDias = :qtdDias", Reserva.class);
		query.setParameter("qtdDias", dias);
		return query.getResultList();
	}
	
	@Override
	public List<Cliente> clientes(){
		TypedQuery<Cliente> query = em.createQuery("from Cliente", Cliente.class);
		return query.getResultList();
	}

	
	@Override
	public List<Pacote> buscarPacotes(Transporte transporte){
		TypedQuery<Pacote> query = em.createQuery("from Pacote.Transporte.id = 1",Pacote.class);
		return query.getResultList();
	}
	
	@Override
	public List<Cliente> clientesEstado(String estado){
		TypedQuery<Cliente> query = em.createQuery("from Cliente.Endereco.Cidade.Estado.uf = 'SP'", Cliente.class);
		return query.getResultList();
	}
	@Override
	public List<Cliente> clientesReserva(int qtdDias){
		//TypedQuery<Cliente> query = em.createQuery("from Cliente")
		return null;
	}
}
