package listas.Asortlist.modelo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Filme implements Comparable<Filme>{
	private String titulo;
	private String descricao;
	private Duration duração;
	private LocalDate dataLancamento;
	private ClassificaoIndicativa classificao;

	public Filme(String titulo, String descricao, Duration duração, LocalDate dataLancamento,
			ClassificaoIndicativa classificao) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.duração = duração;
		this.dataLancamento = dataLancamento;
		this.classificao = classificao;
	}
	
	public Filme() {
		// TODO Auto-generated constructor stub
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Duration getDuração() {
		return duração;
	}

	public void setDuração(long duração) {
		this.duração = Duration.ofMinutes(duração);
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = LocalDate.parse(dataLancamento , DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

	public ClassificaoIndicativa getClassificao() {
		return classificao;
	}

	public void setClassificao(ClassificaoIndicativa classificao) {
		this.classificao = classificao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classificao, dataLancamento, descricao, duração, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return classificao == other.classificao && Objects.equals(dataLancamento, other.dataLancamento)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(duração, other.duração)
				&& Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Filme [titulo=" + titulo + ", descricao=" + descricao + ", duração=" + duração.toMinutes() + ", dataLancamento="
				+ dataLancamento + ", classificao=" + classificao.getLabel() + "]";
	}

	@Override
	public int compareTo(Filme filme) {
		return this.getTitulo().compareToIgnoreCase(filme.getTitulo());
	}
	
	

}
