package br.com.fiap.dao;

import br.com.fiap.entity.Veiculo;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.SearchNotFoundException;
public interface VeiculoDAO {

	
	void cadastrar (Veiculo veiculo);
	Veiculo consultar (int codigo);
	void atualizar (Veiculo veiculo);
	void remover (int codigo)throws SearchNotFoundException;
	void commit() throws CommitException;
	
}
