package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Table(name="T_JOGADOR")
@Entity
@SequenceGenerator(name="jogador", sequenceName="T_SQ_JOGADOR", allocationSize=1)
public class Jogador {
	
	
	@Column(name="cd_jogador")
	@GeneratedValue(generator="jogador", strategy = GenerationType.SEQUENCE )
	private int codigo;
	
	@Column(name="nm_jogador")
	private String nome;
	
	
	@Column(name="ds_posicao")
	@Enumerated(EnumType.STRING)
	private Posicao posicao;
	
	
	@ManyToOne
	@JoinColumn(name="cd_time")
	private Time time;
	
	
}
