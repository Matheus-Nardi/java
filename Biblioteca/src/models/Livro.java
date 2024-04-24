package models;

import java.time.LocalDate;

import models.enumns.ClassificacaoIdade;
import models.enumns.GeneroLivro;

public class Livro {
	private String titulo;
	private String autor;
	private LocalDate anoPublicacao;
	private GeneroLivro genero;
	private ClassificacaoIdade classificacao;
	
	
	public Livro(String titulo, String autor, LocalDate anoPublicacao, GeneroLivro genero,
			ClassificacaoIdade classificacao) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.anoPublicacao = anoPublicacao;
		this.genero = genero;
		this.classificacao = classificacao;
	}
	
	public Livro() {
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(LocalDate anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public GeneroLivro getGenero() {
		return genero;
	}

	public void setGenero(GeneroLivro genero) {
		this.genero = genero;
	}

	public ClassificacaoIdade getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(ClassificacaoIdade classificacao) {
		this.classificacao = classificacao;
	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", autor=" + autor + ", anoPublicacao=" + anoPublicacao + ", genero="
				+ genero.getGenero() + ", classificacao=" + classificacao.getClassificacao() + "]";
	}
	
	
	
	
	
	
	
	
}
