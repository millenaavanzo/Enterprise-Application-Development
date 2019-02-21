package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_CARRO")
@SequenceGenerator(name = "carro", sequenceName = "SQ_TB_CARRO", allocationSize = 1)
public class Carro {

	@Id
	@Column(name = "id_carro", nullable = false)
	@GeneratedValue(generator = "carro", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "ds_nome", nullable = false, length = 50)
	private String nome;

	@Column(name = "ds_marca")
	private String marca;

	@Column(name = "ds_placa", nullable = false)
	private String placa;

	@Column(name = "nr_ano")
	private int ano;

	@Column(name = "ds_cambio")
	@Enumerated(EnumType.STRING) // grava a string da constante
	private Transmissao cambio;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_fabricacao", updatable = false)
	private Calendar dataFabricacao;

	@Transient // NAO E COLUNA NO BANCO DE DADOS
	private boolean ligado;

	@Lob // GRAVA ARQUIVO NO BANCO DE DADOS
	private byte[] documento;

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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Transmissao getCambio() {
		return cambio;
	}

	public void setCambio(Transmissao cambio) {
		this.cambio = cambio;
	}

	public Calendar getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Calendar dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public boolean isLigado() {
		return ligado;
	}

	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}

	public byte[] getDocumento() {
		return documento;
	}

	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}
//CADASTRAR DADOS NO BANCO
	public Carro(String nome, String marca, String placa, int ano, Transmissao cambio, Calendar dataFabricacao,
			byte[] documento) {
		super();

		this.nome = nome;
		this.marca = marca;
		this.placa = placa;
		this.ano = ano;
		this.cambio = cambio;
		this.dataFabricacao = dataFabricacao;
		this.documento = documento;
	}
//ATUALIZAR DADOS NO BANCO
	public Carro(int codigo, String nome, String marca, String placa, int ano, Transmissao cambio, byte[] documento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.marca = marca;
		this.placa = placa;
		this.ano = ano;
		this.cambio = cambio;
		this.documento = documento;
	}

	
	
	public Carro() {
		super();

	}

}
