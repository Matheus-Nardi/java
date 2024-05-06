package javacore.Ycolecoes.models;

import java.util.Objects;

public class Manga {
	private String nome;
	private Double preço;
	private Integer quantidade;
	public Manga(String nome, Double preço, Integer quantidade) {
		super();
		this.nome = nome;
		this.preço = preço;
		this.quantidade = quantidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreço() {
		return preço;
	}
	public void setPreço(Double preço) {
		this.preço = preço;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nome, preço, quantidade);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manga other = (Manga) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(preço, other.preço)
				&& Objects.equals(quantidade, other.quantidade);
	}
	@Override
	public String toString() {
		return "Manga [nome=" + nome + ", preço=" + preço + ", quantidade=" + quantidade + "]";
	}
	
	
	
}
