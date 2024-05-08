package abibliotecaTryCatch.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Livro {
	private String titulo;
	private String autor;
	private LocalDate anoPublicacao;
	private Boolean disponivel;
	
	public Livro(String titulo, String autor, LocalDate anoPublicacao, Boolean disponivel) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.anoPublicacao = anoPublicacao;
		this.disponivel = disponivel;
	}

	public Livro() {
		super();
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

	public String getAnoPublicacao() {
		return anoPublicacao.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

	public void setAnoPublicacao(LocalDate anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anoPublicacao, autor, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(anoPublicacao, other.anoPublicacao) && Objects.equals(autor, other.autor)
				&& Objects.equals(titulo, other.titulo);
	}
	
	
	
	
	
	
	
	
	
}
