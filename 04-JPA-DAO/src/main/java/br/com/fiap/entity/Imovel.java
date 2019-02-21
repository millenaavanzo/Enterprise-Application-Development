package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="T_IMOVEL")
@SequenceGenerator(name="imovel", sequenceName="SQ_T_IMOVEL", allocationSize=1)
public class Imovel {
 /*
	  * 	T_IMOVEL
	  * 	*CD_IMOVEL (PK) (NUMBER) (SEQUENCE)
	  * 	DS_TIPO (VARCHAR) (ENUM)
	  * 	DS_AREA (NUMBER) - TAMANHO
	  * 	DT_CONSTRUCAO(DATE)
	  * 	*DS_LOGRADOURO (VARCHAR(100))
  */
	
	@Id
	@Column(name="cd_imovel")
	@GeneratedValue(generator = "Imovel", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="cd_imovel")
	private Tipo tipo;
	
	
	@Column(name="ds_area")
	private float area;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_construcao")
	private Calendar dataConstrucao;
	
	
	@Column(name="ds_logradouro", nullable=false,length=100)
	private String logradouro;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public Calendar getDataConstrucao() {
		return dataConstrucao;
	}

	public void setDataConstrucao(Calendar dataConstrucao) {
		this.dataConstrucao = dataConstrucao;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Imovel(int codigo, Tipo tipo, float area, Calendar dataConstrucao, String logradouro) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.area = area;
		this.dataConstrucao = dataConstrucao;
		this.logradouro = logradouro;
	}
	
	//SEM CODIGO
	public Imovel( Tipo tipo, float area, Calendar dataConstrucao, String logradouro) {
		super();
	
		this.tipo = tipo;
		this.area = area;
		this.dataConstrucao = dataConstrucao;
		this.logradouro = logradouro;
	}
	
	
	public Imovel() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
