package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="T_USUARIO")
@Entity
@SequenceGenerator(name="usuario", sequenceName="T_SQ_USUARIO",allocationSize=1)
public class Usuario {
	@Id
	@Column(name="cd_usuario")
	@GeneratedValue(generator="usuario", strategy = GenerationType.SEQUENCE)
	private int codigo;
	@Column(name="ds_usuario")
	private String descricao;
	
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

	public List<ItemTeste> getItens() {
		return itens;
	}

	public void setItens(List<ItemTeste> itens) {
		this.itens = itens;
	}

	@ManyToMany(mappedBy="usuarios", cascade=CascadeType.PERSIST)
	private List<ItemTeste> itens;
}
