package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Table(name="T_TECNICO")
@Entity
@SequenceGenerator(name="tecnico", sequenceName="T_SQ_TECNICO", allocationSize=1)
public class Tecnico {
	
	@GeneratedValue(generator="tecnico", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_tecnico")
	private int codigo;
	
	@Column(name="nm_tecnico")
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
	@OneToOne
	@JoinColumn(name="time")
	private Time time;
	
	
}
