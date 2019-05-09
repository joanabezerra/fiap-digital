package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_OCORRENCIA")
@SequenceGenerator(name="ocorrencia",sequenceName="SQ_T_OCORRENCIA",allocationSize=1)
public class Ocorrencia {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ocorrencia")
	private int codigo;
	
	private Calendar data;
	
	private String descricao;
	
	private boolean anonimo;
	
	private String denunciante;
	
	private int artigo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isAnonimo() {
		return anonimo;
	}

	public void setAnonimo(boolean anonimo) {
		this.anonimo = anonimo;
	}

	public String getDenunciante() {
		return denunciante;
	}

	public void setDenunciante(String denunciante) {
		this.denunciante = denunciante;
	}

	public int getArtigo() {
		return artigo;
	}

	public void setArtigo(int artigo) {
		this.artigo = artigo;
	}
	
}