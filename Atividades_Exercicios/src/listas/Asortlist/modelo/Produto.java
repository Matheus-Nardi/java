package listas.Asortlist.modelo;

import java.util.Objects;

public class Produto implements Comparable<Produto> {
	private String nome;
	private Double preco;
	private Boolean disponivel;

	public Produto(String nome, Double preco, Boolean disponivel) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.disponivel = disponivel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(disponivel, nome, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(disponivel, other.disponivel) && Objects.equals(nome, other.nome)
				&& Objects.equals(preco, other.preco);
	}
	
	

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", preco=" + preco + ", disponivel=" + disponivel + "]";
	}

	@Override
	public int compareTo(Produto o) {
		int comparacaoPreco = Double.compare(this.preco, o.getPreco());
		if(comparacaoPreco == 0) // Possuem o mesmo preço ?
			return Boolean.compare(this.disponivel, o.getDisponivel());
		
		return comparacaoPreco;
			
	}
}
