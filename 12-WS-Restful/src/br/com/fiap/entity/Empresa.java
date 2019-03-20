package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_EMPRESA")
@SequenceGenerator(name = "SQ_EMPRESA", sequenceName = "SQ_T_EMPRESA", allocationSize = 1)
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa")
	@Column(name = "CD_EMPRESA")
	private int codigo;
	
	private String nome;
	
	private double faturamento;
	
	private boolean multinacional;

}
