package br.com.fiap.dao;

import br.com.fiap.entity.Veiculo;

public interface VeiculoDAO {

	
	void cadastrar (Veiculo veiculo);
	Veiculo consultar (int codigo);
	void atualizar (Veiculo veiculo);
	void remover (int codigo)throws SearchNotFoundException;
	void commit() throws CommitException;
	
}
