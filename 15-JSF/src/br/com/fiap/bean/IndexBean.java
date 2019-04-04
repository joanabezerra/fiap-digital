package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class IndexBean {
	
	private String nome;
	
	public void showName() {
		System.out.println(nome);		
	}

}
