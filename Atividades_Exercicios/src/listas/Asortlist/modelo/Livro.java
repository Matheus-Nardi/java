package listas.Asortlist.modelo;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Livro implements Comparable<Livro> {
	private String titulo;
	private String autor;
	private LocalDate dataLancamento;

	public Livro(String titulo, String autor, LocalDate dataLancamento) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.dataLancamento = dataLancamento;
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

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, dataLancamento, titulo);
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
		return Objects.equals(autor, other.autor) && Objects.equals(dataLancamento, other.dataLancamento)
				&& Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Título = " + titulo + "\nAutor = " + autor + "\nData de lancamento=" + dataLancamento;
	}

	@Override
	public int compareTo(Livro o) {
		if(this.titulo.equalsIgnoreCase(o.getTitulo()))
			return this.autor.compareToIgnoreCase(o.getAutor());
		
		return this.titulo.compareToIgnoreCase(o.getTitulo());
	}
	
	

}
