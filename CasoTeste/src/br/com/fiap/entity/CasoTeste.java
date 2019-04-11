package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Table(name="T_CASO_TESTE")
@Entity
@SequenceGenerator(name="casoTeste", sequenceName="T_SQ_CASO_TESTE", allocationSize=1)
public class CasoTeste {
	
	@Id
	@Column(name="cd_caso_teste")
	@GeneratedValue(generator="casoTeste", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_caso_teste")
	private String descricao;
	
	
	//GET E SET
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public CasoTeste(int codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public CasoTeste(String descricao) {
		super();
		this.descricao = descricao;
	}
	public CasoTeste() {
		
	}
	//RELACIONAMENTO
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cod_sistema")
	private Sistema sistema;
	
	@OneToMany(mappedBy="casoTeste")
	@JoinColumn(name="cd_item_teste")
	private List<ItemTeste> itens;


	public Sistema getSistema() {
		return sistema;
	}
	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	public List<ItemTeste> getItens() {
		return itens;
	}
	public void setItens(List<ItemTeste> itens) {
		this.itens = itens;
	}
}
