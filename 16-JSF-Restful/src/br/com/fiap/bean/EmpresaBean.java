package br.com.fiap.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.exception.ResponseException;
import br.com.fiap.repository.EmpresaRepository;
import br.com.fiap.to.Empresa;

@ManagedBean
@ViewScoped
public class EmpresaBean implements Serializable{

	private Empresa empresa;
	
	private EmpresaRepository rep;
	
	@PostConstruct
	public void init() {
		empresa = new Empresa();
		rep = new EmpresaRepository();
	}
	
	public void excluir(int codigo) {
		try {
			rep.remover(codigo);
		} catch (ResponseException e) {
			e.printStackTrace();
			exibirMensagem("Erro!");
		}
	}
	
	public void exibirMensagem(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public List<Empresa> listar(){
		try {
			return rep.listar();
		} catch (ResponseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void cadastrar() {
		try {
			if(empresa.getCodigo() == 0) {
				rep.cadastrar(empresa);
				exibirMensagem("Cadastrado!");
			}else {
				rep.atualizar(empresa);
				exibirMensagem("Atualizado!");
			}
		} catch (ResponseException e) {
			e.printStackTrace();
			exibirMensagem("Erro..");
		}
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}
