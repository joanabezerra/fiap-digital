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
@SequenceGenerator(name = "empresa", sequenceName = "SQ_T_EMPRESA", allocationSize = 1)
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa")
	@Column(name = "CD_EMPRESA")
	private int codigo;
	
	@Column(name = "NM_EMPRESA", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "VL_FATURAMENTO", nullable = false)
	private double faturamento;
	
	@Column(name = "ST_MULTINACIONAL", nullable = false)
	private boolean multinacional;

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

	public double getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(double faturamento) {
		this.faturamento = faturamento;
	}

	public boolean isMultinacional() {
		return multinacional;
	}

	public void setMultinacional(boolean multinacional) {
		this.multinacional = multinacional;
	}

}
