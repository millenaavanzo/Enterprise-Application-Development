package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CAMPEONATO")
@SequenceGenerator(name="campeonato",sequenceName="T_SQ_CAMPEONATO",allocationSize=1)
public class Campeonato {
	
	@Column(name="cd_campeonato")
	@GeneratedValue(generator="campeonato", strategy= GenerationType.SEQUENCE)
	private int codigo;
	
	
	@Column(name="nm_campeonato")
	private String nome;
	
	@Column(name="ds_premiacao")
	private double premiacao;
	
	
	@Column(name="ds_local")
	private String local;
	
	
}
