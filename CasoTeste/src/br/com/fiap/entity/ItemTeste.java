package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "T_ITEM_TESTE")
@Entity
@SequenceGenerator(name = "itemTeste", sequenceName = "T_SQ_ITEM_TESTE", allocationSize = 1)
public class ItemTeste {

	@Id
	@Column(name = "cd_item_teste")
	@GeneratedValue(generator = "itemTeste", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "ds_item_teste")
	private String descricao;

	public ItemTeste() {
		super();
	}

	public ItemTeste(String descricao, CasoTeste casoTeste) {
		super();
		this.descricao = descricao;
		this.casoTeste = casoTeste;
	}

	public ItemTeste(int codigo, String descricao, CasoTeste casoTeste) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.casoTeste = casoTeste;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CasoTeste getCasoTeste() {
		return casoTeste;
	}

	public void setCasoTeste(CasoTeste casoTeste) {
		this.casoTeste = casoTeste;
	}

	// RELACIONAMENTO
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cod_caso_teste")
	private CasoTeste casoTeste;

	@ManyToMany
	@JoinTable(name = "TAB_ITEM_TESTE_USUARIO",
	joinColumns = 
	@JoinColumn(name = "cd_item_teste"),
	inverseJoinColumns =
	@JoinColumn(name = "cd_usuario"))
	private List<Usuario> usuarios;

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
