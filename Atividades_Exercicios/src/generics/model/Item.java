package generics.model;

import java.util.Objects;

public abstract class Item implements Comparable<Item> {
	private String nome;
	private Double preco;

	public Item(String nome, Double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(preco, other.preco);
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

	@Override
	public String toString() {
		return "Item [nome=" + nome + ", preco=" + preco + "]";
	}
	
	@Override
	public int compareTo(Item o) {
		return this.getNome().compareToIgnoreCase(o.getNome());
	}

}
