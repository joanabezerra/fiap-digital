package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ValidacaoBean {
	
	private String usuario;
	private String senha;
	private String msg;
	
	public void validar() {
		if(getUsuario().equals("FIAP")  && getSenha().equals("FIAP2019")) {
			System.out.println("Logado com sucesso!");
			msg = "Logado com sucesso!";
		} else {
			System.out.println("Usuário ou senha incorreto.");
			msg = "Usuário ou senha incorreto.";
		}
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
