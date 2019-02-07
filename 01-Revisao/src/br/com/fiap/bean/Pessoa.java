package br.com.fiap.bean;

import java.util.Calendar;

public class Pessoa {

	/*
	 * constante no java:
	 * public static final char ESPECIE = 'h';
	 * nome da variavel é maiusculo
	 */
	
	private String nome;
	private Calendar dataNascimento;
	private Genero sexo;
	
	
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
	public Genero getSexo() {
		return sexo;
	}
	public void setSexo(Genero sexo) {
		this.sexo = sexo;
	}
	
	
	
	
	
}
