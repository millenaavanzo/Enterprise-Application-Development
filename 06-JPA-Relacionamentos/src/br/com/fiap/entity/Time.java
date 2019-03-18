package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="T_TIME")
@Entity
@SequenceGenerator(name="time", sequenceName="T_SQ_TIME", allocationSize=1)
public class Time {
	
	
	@Column(name="cd_time")
	@GeneratedValue(generator="time", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	
	@Column(name="nm_time")
	private String nome;
	
	@Column(name="nm_titulos")
	private int titulos;
	
	
	@OneToOne(mappedBy="time")
	private Tecnico tecnico;
	
	@OneToMany(mappedBy="time")
	private List<Jogador> jogador;
}
