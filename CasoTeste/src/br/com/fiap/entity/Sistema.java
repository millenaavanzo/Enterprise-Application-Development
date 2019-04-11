package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_SISTEMA")
@SequenceGenerator(name="sistema", sequenceName="T_SQ_SISTEMA", allocationSize=1)
public class Sistema {
	
	
	@Id
	@Column(name="cd_sistema")
	@GeneratedValue(generator="sistema", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_nome")
	private String nome;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Sistema(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	public Sistema(String nome) {
		super();
		this.nome = nome;
	}

	public Sistema() {
		super();
	}
//RELACIONAMENTO
	@OneToMany
	//SE TERMINA COM MANY É UMA LISTA
	@JoinColumn(name="sistema")
	private List<CasoTeste> casoTeste;

	public List<CasoTeste> getCasoTeste() {
		return casoTeste;
	}
	public void setCasoTeste(List<CasoTeste> casoTeste) {
		this.casoTeste = casoTeste;
	}
	
	
}
