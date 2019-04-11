package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Reserva;
import br.com.fiap.entity.Transporte;

public interface ReservaDAO extends GenericDAO<Reserva,Integer>{
List<Reserva> listar();
List<Reserva> buscarPorNumeroDias(int dias);
List<Cliente> clientes();
List<Pacote> buscarPacotes(Transporte transporte);
List<Cliente> clientesEstado(String estado);
List<Cliente> clientesReserva(int qtdDias);
}
