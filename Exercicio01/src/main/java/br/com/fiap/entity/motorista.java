package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="T_MOTORISTA")

public class Motorista {
	
	
	@Id
	@Column(name="NR_CARTEIRA")
	private int numero;
	
	@Column(name="NM_MOTORISTA")
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
	@Lob
	@Column(name="fl_carteira")
	private byte[] carteira;
	
	
	@Column(name="DS_GENERO")
	private Genero genero;

	
	//GET E SET
	

	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Calendar getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public byte[] getCarteira() {
		return carteira;
	}


	public void setCarteira(byte[] carteira) {
		this.carteira = carteira;
	}




public Genero getGenero() {
		return genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	//CONSTRUTORES
	public Motorista(int numero, String nome, Calendar dataNascimento, byte[] carteira, Genero genero) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.carteira = carteira;
		this.genero = genero;
	}
	
	public Motorista() {
		
	}
	
	
	
	
	
	
}
