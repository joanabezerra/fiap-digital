package br.com.fiap.to;

public class Filme {
	
	private String titulo;
	
	private String classificacao;
	
	private float duracao;
	
	private String estudio;
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public float getDuracao() {
		return duracao;
	}

	public void setDuracao(float duracao) {
		this.duracao = duracao;
	}

	public String getEstudio() {
		return estudio;
	}

	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}

	public boolean isNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(boolean nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	private boolean nacionalidade;
	
	

}
