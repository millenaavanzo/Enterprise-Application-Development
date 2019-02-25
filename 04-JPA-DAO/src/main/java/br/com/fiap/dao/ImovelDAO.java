package br.com.fiap.dao;

import br.com.fiap.entity.Imovel;
import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.SearchNotFoundException;

public interface ImovelDAO {
	//Coloca so as assinaturas do metodos
	//a classe que usar a interface tem que implementar
	
	
	void cadastrar(Imovel imovel);
	
	//SE NÃO POR PUBLICO FUNCIONA
	public Imovel consultar(int codigo);
	
	
	void atualizar(Imovel imovel);
	
	void remover (int codigo) throws SearchNotFoundException;
	
	void commit() throws CommitException;
}
