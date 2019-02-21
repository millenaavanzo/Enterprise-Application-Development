package br.com.fiap.entity;

import java.util.Date;
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
@Table(name = "T_ZOOLOGICO")
@SequenceGenerator(name = "zoologico", sequenceName = "SQ_T_ZOOLOGICO", allocationSize = 1)
public class Zoologico {

	@Id
	@Column(name = "id_zoologico", nullable = false)
	@GeneratedValue(generator = "zoologico", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "ds_nome",nullable=false, length = 50)
	private String nome;

	@Column(name = "qt_animais")
	private int quantidade;

	@Column(name = "ds_tipo")
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	@Temporal(TemporalType.TIME)
	@Column(name = "hr_abertura")
	private Date dataAbertura;
	
	
	@Temporal(TemporalType.TIME)
	@Column(name = "hr_fechamento")
	private Date dataFechamento;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_inauguracao")
	private Date dataInauguracao;

	@Column(name = "ds_emergencia")
	private boolean emergencia;

	@Column(name = "ds_logo")
	@Lob
	private byte[] logo;
	
	@Transient 
	private boolean aberto;

	
	
	
	
	
	
	//UPDATE
	public Zoologico(String nome, int quantidade, Tipo tipo, Date dataAbertura, Date dataFechamento,
			Date dataInauguracao, boolean emergencia, byte[] logo) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.tipo = tipo;
		this.dataAbertura = dataAbertura;
		this.dataFechamento = dataFechamento;
		this.dataInauguracao = dataInauguracao;
		this.emergencia = emergencia;
		this.logo = logo;
	}
//CADASTRO
	public Zoologico(int codigo, String nome, int quantidade, Tipo tipo, Date dataAbertura, Date dataFechamento,
			Date dataInauguracao, boolean emergencia, byte[] logo, boolean aberto) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.quantidade = quantidade;
		this.tipo = tipo;
		this.dataAbertura = dataAbertura;
		this.dataFechamento = dataFechamento;
		this.dataInauguracao = dataInauguracao;
		this.emergencia = emergencia;
		this.logo = logo;
		this.aberto = aberto;
	}

	public boolean isAberto() {
		return aberto;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Date getDataInauguracao() {
		return dataInauguracao;
	}

	public void setDataInauguracao(Date dataInauguracao) {
		this.dataInauguracao = dataInauguracao;
	}

	public boolean isEmergencia() {
		return emergencia;
	}

	public void setEmergencia(boolean emergencia) {
		this.emergencia = emergencia;
	}

	public Zoologico() {
		super();
	}

}
