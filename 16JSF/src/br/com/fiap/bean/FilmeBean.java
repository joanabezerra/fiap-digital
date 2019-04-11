package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.bo.FilmeBO;
import br.com.fiap.to.Filme;

@ManagedBean
public class FilmeBean {

	private Filme filme;
	private FilmeBO bo;
	
	@PostConstruct
	public void Iniciar() {
		bo = new FilmeBO();
		filme = new Filme();
	}
	
	public List<Filme> listar(){
		return bo.listar();
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

}
